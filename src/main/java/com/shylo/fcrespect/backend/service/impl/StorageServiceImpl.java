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
    private final Path otherImgFolderName;


    @Autowired
    public StorageServiceImpl(@Value("${files.path.root}") String fileLocation,
                              @Value("${files.path.players}") String playerImgFolderName,
                              @Value("${files.path.news}") String newsImgFolderName,
                              @Value("${files.path.other}") String otherImgFolderName) {
        this.rootLocation = Paths.get(fileLocation);
        this.playerImgFolderName = rootLocation.resolve(playerImgFolderName);
        this.newsImgFolderName = rootLocation.resolve(newsImgFolderName);
        this.otherImgFolderName = rootLocation.resolve(otherImgFolderName);
        init();
    }

    @Override
    public void init() {
        try {
            LOGGER.info("Trying to create dir for uploaded files with location: " + rootLocation);
            Files.createDirectory(rootLocation);
            LOGGER.info("Dir for uploaded files was successfully created with location: " + rootLocation);

            LOGGER.info("Trying to create dir for uploaded files with location: " + playerImgFolderName);
            Files.createDirectory(playerImgFolderName);
            LOGGER.info("Dir for uploaded files was successfully created with location: " + playerImgFolderName);

            LOGGER.info("Trying to create dir for uploaded files with location: " + newsImgFolderName);
            Files.createDirectory(newsImgFolderName);
            LOGGER.info("Dir for uploaded files was successfully created with location: " + newsImgFolderName);

            LOGGER.info("Trying to create dir for uploaded files with location: " + otherImgFolderName);
            Files.createDirectory(otherImgFolderName);
            LOGGER.info("Dir for uploaded files was successfully created with location: " + otherImgFolderName);
        } catch (FileAlreadyExistsException e) {
            LOGGER.warn(e.getLocalizedMessage());
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public void store(MultipartFile file, UploadType type) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            copyFileToTypeDir(file, type);
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    private void copyFileToTypeDir(MultipartFile file, UploadType type) throws IOException {
        String extension = file.getOriginalFilename().split("\\.")[1];
        switch (type) {
            case PLAYER_IMAGE:
                Files.copy(file.getInputStream(), this.playerImgFolderName.resolve(playerImgFolderName.getFileName() +
                        "_" + System.currentTimeMillis() + "." + extension));
                break;
            case NEWS_IMAGE:
                Files.copy(file.getInputStream(), this.newsImgFolderName.resolve(newsImgFolderName.getFileName() +
                        "_" + System.currentTimeMillis() + "." + extension));
                break;
            default:
                Files.copy(file.getInputStream(), this.otherImgFolderName.resolve(otherImgFolderName.getFileName() + "_" + System.currentTimeMillis() +
                        "_" + System.currentTimeMillis() + "." + extension));
        }
    }
}
