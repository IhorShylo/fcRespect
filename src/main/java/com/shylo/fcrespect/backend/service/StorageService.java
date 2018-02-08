package com.shylo.fcrespect.backend.service;

import com.shylo.fcrespect.backend.enums.UploadType;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {
    void init();

    void store(MultipartFile file, UploadType type);

    public Path load(String filename);

    void deleteAll();
}
