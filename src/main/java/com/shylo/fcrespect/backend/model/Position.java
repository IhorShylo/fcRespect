package com.shylo.fcrespect.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "positions" )
public class Position implements Serializable {

    private static final long serialVersionUID = 8304731063153683941L;

    @Id
    @Column( name = "position_id", nullable = false, updatable = false )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "position_value", nullable = false, unique = true)
    private String value;
}
