package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.dto.MailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/contacts")
public class ContactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsController.class);

    @RequestMapping
    public String contactsPage(ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        MailRequest mailRequest = new MailRequest();
        modelMap.put("mailRequest", mailRequest);
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.CONTACTS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

    @RequestMapping(value = "/form-process", method = RequestMethod.POST)
    public String processForm(@ModelAttribute(value = "mailRequest") MailRequest mailRequest, ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        LOGGER.info("Recieved feedback messages = {}", mailRequest);


        LOGGER.warn("Should send mail!!!");
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.CONTACTS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

}
