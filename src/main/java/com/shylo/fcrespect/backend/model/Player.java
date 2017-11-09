package com.shylo.fcrespect.backend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table( name = "players" )
public class Player implements Serializable {

    private static final long serialVersionUID = 2553354636906318627L;

    @Id
    @Column( name = "players_id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @Column( name = "full_name" )
    private String fullName;

    @Column (name = "birthday")
    private LocalDate birthday;

    @Column( name = "image_name" )
    private String imageName;

    @Column( name = "position" )
    private String position;

    public Player( String fullName, LocalDate birthday, String position, String imageName ) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = position;
        this.imageName = imageName;
    }

    public Player() {
    }
}
