package com.shylo.fcrespect.backend.enums;

import lombok.Getter;

@Getter
public enum PositionValue {
    GOALKEEPER( "Goalkeeper" ),
    DEFENDER( "Defender" ),
    MIDFIELDER( "Midfielder" ),
    FORWARD( "Forward" );

    private final String value;

    PositionValue( String value ) {
        this.value = value;
    }
}
