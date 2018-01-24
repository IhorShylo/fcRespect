package com.shylo.fcrespect.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table( name = "positions" )
public class Position implements Serializable {

    private static final long serialVersionUID = 8304731063153683941L;

    @Id
    @Column( name = "position_id", nullable = false, updatable = false )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "position_value", nullable = false, updatable = false )
    private String value;
}
