package com.shylo.fcrespect.backend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class News implements Serializable {

    private static final long serialVersionUID = -1503453064461116227L;

    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "text")
    private String text;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

}
