package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping( value = "/" )
    public String homePage( ModelMap modelMap, HttpServletRequest request ) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        modelMap.addAttribute( ProjectConstants.CONTENT_KEY, ViewConstants.HOME_VIEW );
        return ProjectConstants.HOME_PAGE_KEY;
    }
}
