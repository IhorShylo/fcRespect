package com.shylo.fcrespect.backend.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ValidationErrorResponse extends ErrorResponse {

    private final String field;
    private final String message;
}
