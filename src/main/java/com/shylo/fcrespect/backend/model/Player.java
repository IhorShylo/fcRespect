package com.shylo.fcrespect.backend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class Player {
    private String fullName;
    private LocalDate birthDay;
    private String position;
    private String imageName;

    public Player(String fullName, LocalDate birthDay, String position, String imageName ) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.position = position;
        this.imageName = imageName;
    }

    public Player() {
    }
}
