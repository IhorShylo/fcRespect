package com.shylo.fcrespect.backend.model;

import com.shylo.fcrespect.backend.enums.Position;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table( name = "players" )
public class Player implements Serializable {

    private static final long serialVersionUID = 2553354636906318627L;

    @Id
    @Column( name = "players_id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "full_name" )
    private String fullName;

    @Column (name = "birthday")
    private LocalDate birthday;

    @Column( name = "image_name" )
    private String imageName;

    @Column( name = "position" )
    @Enumerated(EnumType.ORDINAL)
    private Position position;

}
