package com.shylo.fcrespect.backend.model;

import com.shylo.fcrespect.backend.annotation.MappedEnum;
import com.shylo.fcrespect.backend.enums.Position;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "position")
@MappedEnum( enumClass = Position.class)
public class PositionEx extends SystemDictionary {
}
