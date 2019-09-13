package com.shylo.fcrespect.backend.dto.req.news;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewsUpdateRequest {
    private String title;
    private String imageName;
    private String text;
    private LocalDateTime updateTime;
}
