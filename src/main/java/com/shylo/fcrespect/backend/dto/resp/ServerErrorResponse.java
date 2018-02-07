package com.shylo.fcrespect.backend.dto.resp;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ServerErrorResponse {
    private String message;
    List<ErrorResponse> errors;

    public ServerErrorResponse(String message) {
        this.message = message;
        if (errors == null) this.errors = Collections.emptyList();
    }

    public ServerErrorResponse(String message, List<ErrorResponse> errors) {
        this.message = message;
        if (errors == null) {
            this.errors = Collections.emptyList();
        } else {
            this.errors = errors;
        }

    }

}
