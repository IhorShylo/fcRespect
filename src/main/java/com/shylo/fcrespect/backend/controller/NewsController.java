package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.enums.UploadType;
import com.shylo.fcrespect.backend.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    private final StorageService storageService;

    @Autowired
    public NewsController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping
    public String newsPage(ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.NEWS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

    @RequestMapping(value = "/create/upload", method = RequestMethod.POST)
    public String uploadNewsImage(@RequestParam("file") MultipartFile file, ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        storageService.store(file, UploadType.NEWS_IMAGE);
        modelMap.addAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.NEWS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

}
