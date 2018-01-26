package com.shylo.fcrespect.backend.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

@Data
public class MailRequest {
    @Size(min = 2, max = 25)
    private String name;
    @Email
    private String email;
    @Size(min = 2, max = 200)
    private String message;
}
