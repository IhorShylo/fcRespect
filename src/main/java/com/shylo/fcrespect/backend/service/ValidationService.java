package com.shylo.fcrespect.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface ValidationService {
   void isFileValid(MultipartFile file);
}
