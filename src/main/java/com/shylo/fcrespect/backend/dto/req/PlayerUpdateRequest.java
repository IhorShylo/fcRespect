package com.shylo.fcrespect.backend.dto.req;

import lombok.Value;

import java.time.LocalDate;

@Value
public class PlayerUpdateRequest {
    private String fullName;
    private LocalDate birthday;
    private String imageName;
    private String position;
    private String about;
    private Integer height;
    private String birthPlace;

    private Integer statisticId;
    private LocalDate inClub;
    private Integer games;
    private Integer goals;
    private Integer assists;
}
