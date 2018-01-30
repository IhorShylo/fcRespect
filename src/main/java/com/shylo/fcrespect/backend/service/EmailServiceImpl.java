package com.shylo.fcrespect.backend.service;

import com.shylo.fcrespect.backend.controller.ContactsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsController.class);


    @Autowired
    JavaMailSender mailSender;

    @Override
    @Async
    public void sendSimpleMessage(String to, String subject, String text) {
        LOGGER.info("Sending email to " + to + " ...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        LOGGER.info("Email was send");
    }
}
