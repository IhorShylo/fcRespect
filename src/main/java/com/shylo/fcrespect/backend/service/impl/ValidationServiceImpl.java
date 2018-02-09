package com.shylo.fcrespect.backend.service.impl;

import com.shylo.fcrespect.backend.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final String maxFileSize;

    @Autowired
    public ValidationServiceImpl(@Value("${files.upload.max-file-size}") String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    @Override
    public void isFileValid(MultipartFile file) {
        long fileSize = file.getSize();
        String contentType = file.getContentType();
        if (file.isEmpty()) {
            throw new ValidationException(String.format("Failed to store empty file %s", file.getOriginalFilename()));
        }
        if (fileSize > Long.valueOf(maxFileSize)) {
            throw new ValidationException(String.format("File size (%s) exceeds the configured maximum (%s)", fileSize, maxFileSize));
        }
        if (!"image/jpeg".equalsIgnoreCase(contentType) && !"image/png".equalsIgnoreCase(contentType)) {
            throw new ValidationException(String.format("Actual content type of upload file (%s), expected types (image/png, image/jpeg)", contentType));
        }
    }
}
