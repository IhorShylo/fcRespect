package com.shylo.fcrespect.backend.dto;

import lombok.Data;

@Data
public class MailRequest {
    private String name;
    private String email;
    private String message;
}
