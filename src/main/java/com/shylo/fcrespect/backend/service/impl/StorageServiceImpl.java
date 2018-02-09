package com.shylo.fcrespect.backend.service.impl;

import com.shylo.fcrespect.backend.controller.NewsController;
import com.shylo.fcrespect.backend.enums.UploadType;
import com.shylo.fcrespect.backend.exception.StorageException;
import com.shylo.fcrespect.backend.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    private final Path rootLocation;
    private final Path playerImgFolderName;
    private final Path newsImgFolderName;
    private final Path tmpFilesFolderName;


    @Autowired
    public StorageServiceImpl(@Value("${files.path.root}") String fileLocation,
                              @Value("${files.path.players}") String playerImgFolderName,
                              @Value("${files.path.news}") String newsImgFolderName,
                              @Value("${files.path.tmp}") String tmpFilesFolderName) {
        this.rootLocation = Paths.get(fileLocation);
        this.playerImgFolderName = rootLocation.resolve(playerImgFolderName);
        this.newsImgFolderName = rootLocation.resolve(newsImgFolderName);
        this.tmpFilesFolderName = rootLocation.resolve(tmpFilesFolderName);
    }

    @Override
    public void init() {
        try {
            createFolder(rootLocation);
            createFolder(playerImgFolderName);
            createFolder(newsImgFolderName);
            createFolder(tmpFilesFolderName);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    private void createFolder(Path path) throws IOException {
        try {
            LOGGER.info("Trying to create dir for uploaded files with location: " + path);
            Files.createDirectory(path);
            LOGGER.info("Dir for uploaded files was successfully created with location: " + path);
        } catch (FileAlreadyExistsException e) {
            LOGGER.warn("Directory {} already exist", path);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Path store(MultipartFile file, UploadType type) {
        try {
            return copyFileToTypeDir(file, type);
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    private Path copyFileToTypeDir(MultipartFile file, UploadType type) throws IOException {
        Path path;
        String extension = file.getOriginalFilename().split("\\.")[1];
        switch (type) {
            case PLAYER_IMAGE:
                path = this.playerImgFolderName.resolve(playerImgFolderName.getFileName() +
                        "_" + System.currentTimeMillis() + "." + extension);
                break;
            case NEWS_IMAGE:
                path = this.newsImgFolderName.resolve(newsImgFolderName.getFileName() +
                        "_" + System.currentTimeMillis() + "." + extension);
                break;
            case TMP_FILE:
                path = this.tmpFilesFolderName.resolve(tmpFilesFolderName.getFileName() +
                        "_" + System.currentTimeMillis() + "." + extension);
                break;
            default:
                path = this.tmpFilesFolderName.resolve(tmpFilesFolderName.getFileName() + "_" + System.currentTimeMillis() +
                        "_" + System.currentTimeMillis() + "." + extension);
        }
        Files.copy(file.getInputStream(), path);
        return path;
    }
}
