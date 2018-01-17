package com.shylo.fcrespect.backend.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention( value = RetentionPolicy.RUNTIME)
public @interface MappedEnum {
    Class<? extends Enum> enumClass();
}
