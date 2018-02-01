package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.dto.FeedbackRequest;
import com.shylo.fcrespect.backend.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/contacts")
public class ContactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsController.class);

    private static final String HOME_MAIL = "igor_shilo@ukr.net";
    private static final String DEFAULT_SUBJECT = "Заявка в клуб";

    @Autowired
    EmailService emailService;

    @RequestMapping
    public String contactsPage(@ModelAttribute(value = "feedback") FeedbackRequest feedback, ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.CONTACTS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

    @RequestMapping(value = "/form-process", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute(value = "feedback") FeedbackRequest feedback, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) throws BindException {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.CONTACTS_VIEW);
            throw new BindException(bindingResult);
        }

        String text = formMailBody(feedback);
        emailService.sendSimpleMessage(HOME_MAIL, DEFAULT_SUBJECT, text);
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.CONTACTS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

    private String formMailBody(FeedbackRequest feedback) {
        return "Name: " + feedback.getName() + "\n" + "Phone: " + feedback.getPhone() + "\n" + "Mail: " + feedback.getEmail() + "\n\n" + feedback.getMessage();
    }

}
