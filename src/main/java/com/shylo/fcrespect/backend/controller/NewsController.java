package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.enums.UploadType;
import com.shylo.fcrespect.backend.model.News;
import com.shylo.fcrespect.backend.service.StorageService;
import com.shylo.fcrespect.backend.service.ValidationService;
import com.shylo.fcrespect.backend.service.impl.NewsServiceImpl;
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
import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    private final StorageService storageService;

    private final ValidationService validationService;

    private final NewsServiceImpl newsService;

    @Autowired
    public NewsController(StorageService storageService, ValidationService validationService, NewsServiceImpl newsService) {
        this.storageService = storageService;
        this.validationService = validationService;
        this.newsService = newsService;
    }

    @RequestMapping
    public String newsPage(ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        List<News> allNews = newsService.findAllNews();
        modelMap.addAttribute("news", allNews);
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.NEWS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }


    @RequestMapping(value = "/create")
    public String createPage(ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);

        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.CREATE_NEWS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }




    @RequestMapping(value = "/create/upload", method = RequestMethod.POST)
    public String uploadNewsImage(@RequestParam("file") MultipartFile file, ModelMap modelMap, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        validationService.isFileValid(file);
        Path tmpFilePath = storageService.store(file, UploadType.TMP_FILE);
        modelMap.addAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        modelMap.addAttribute("tmpFilePath", tmpFilePath);

        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.CREATE_NEWS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

}
