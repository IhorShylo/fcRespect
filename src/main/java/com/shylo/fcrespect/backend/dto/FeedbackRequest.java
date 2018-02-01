package com.shylo.fcrespect.backend.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class FeedbackRequest {
    @Size(min = 2, max = 25)
    private String name;

    @Pattern(regexp = "[\\d]{9}")
    private String phone;

    @Size(min = 5, max = 25)
    @Email
    private String email;

    @Size(min = 2, max = 500)
    private String message;
}
