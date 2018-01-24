package com.shylo.fcrespect.backend.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "players")
public class Player implements Serializable {

    private static final long serialVersionUID = 2553354636906318627L;

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "image_name")
    private String imageName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "about")
    private String about;

    @Column(name = "height")
    private Integer height;

    @Column(name = "birth_place")
    private String birthPlace;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statistic_id", nullable = false, unique = true)
    private Statistic statistic = new Statistic();
}
