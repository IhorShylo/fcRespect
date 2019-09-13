package com.shylo.fcrespect.backend.dto.req.player;

import lombok.Value;

import java.time.LocalDate;

@Value
public class PlayerCreateRequest {
    private String fullName;
    private LocalDate birthday;
    private String imageName;
    private String position;
    private String about;
    private Integer height;
    private String birthPlace;
}
