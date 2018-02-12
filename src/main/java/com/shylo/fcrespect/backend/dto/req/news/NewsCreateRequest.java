package com.shylo.fcrespect.backend.dto.req.news;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewsCreateRequest {
    private String title;
    private String imageName;
    private String text;
    private LocalDateTime creationTime;
}
