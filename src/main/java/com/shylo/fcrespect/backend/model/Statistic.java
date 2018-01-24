package com.shylo.fcrespect.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table (name = "statistic")
public class Statistic implements Serializable {

    @Id
    @Column( name = "statistic_id", nullable = false, updatable = false )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "in_club", nullable = false)
    private LocalDate inClub = LocalDate.now();

    @Column(name = "games", nullable = false)
    private Integer games = 0;

    @Column(name = "goals", nullable = false)
    private Integer goals = 0;

    @Column(name = "assists", nullable = false)
    private Integer assists = 0;

}
