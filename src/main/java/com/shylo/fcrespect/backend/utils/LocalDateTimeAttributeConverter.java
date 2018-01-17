package com.shylo.fcrespect.backend.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Converter( autoApply = true )
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn( LocalDateTime localDateTime ) {
        if ( localDateTime != null ) {
            return Timestamp.valueOf( localDateTime );
        } else return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute( Timestamp sqlTimestamp ) {
        if ( sqlTimestamp != null ) {
            return sqlTimestamp.toLocalDateTime();
        } else return null;
    }
}
