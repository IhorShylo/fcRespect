package com.shylo.fcrespect.backend.dto.req;

import lombok.Value;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Value
public class FeedbackRequest {
    @Size(min = 2, max = 25, message = "{Size.feedback.name}")
    private String name;

    @Pattern(regexp = "[\\d]{9}", message = "{Pattern.feedback.phone}")
    private String phone;

    @Size(min = 5, max = 25, message = "{Size.feedback.email}")
    @Email(message = "{Email.feedback.email}")
    private String email;

    @Size(min = 2, max = 500, message = "{Size.feedback.message}")
    private String message;
}
