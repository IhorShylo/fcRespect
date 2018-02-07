package com.shylo.fcrespect.backend.service;

import com.shylo.fcrespect.backend.enums.UploadType;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void init();

    void store(MultipartFile file, UploadType type);

    void deleteAll();
}
