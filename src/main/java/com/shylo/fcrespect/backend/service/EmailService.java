package com.shylo.fcrespect.backend.service;

import com.shylo.fcrespect.backend.dto.FeedbackRequest;

public interface EmailService {

    void sendSimpleMessage (String to, String subject, String text);
    String formMailBody(FeedbackRequest feedback);
}
