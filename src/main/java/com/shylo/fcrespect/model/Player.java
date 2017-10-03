package com.shylo.fcrespect.model;

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
    private String imgName;

    public Player(String fullName, LocalDate birthDay, String position, String imgName) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.position = position;
        this.imgName = imgName;
    }

    public Player() {
    }
}
