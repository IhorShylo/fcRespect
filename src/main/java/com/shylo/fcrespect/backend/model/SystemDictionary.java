package com.shylo.fcrespect.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class SystemDictionary {
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "code")
    private String code;
}
