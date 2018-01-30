package com.shylo.fcrespect.backend.dto;

import lombok.Data;

@Data
public class ErrorResponse {

    private final String field;
    private final String message;
}
