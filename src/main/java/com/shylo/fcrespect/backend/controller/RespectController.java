package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.dao.impl.PlayerDao;
import com.shylo.fcrespect.backend.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RespectController {

    @Autowired
    PlayerDao playerDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(RespectController.class);

    @RequestMapping( value = "/" )
    public String homePage( ModelMap modelMap, HttpServletRequest request ) {
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);
        modelMap.addAttribute( ProjectConstants.CONTENT_KEY, ViewConstants.HOME_VIEW );
        return "home";
    }


    @RequestMapping( value = "/team" )
    public String teamPage( ModelMap modelMap,  HttpServletRequest request) {

        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        LOGGER.info("Enter in controller with path - {}", restOfTheUrl);

        List<Player> allPlayers = playerDao.findAll();
        Player babich = playerDao.findOne( 1 );
        modelMap.put( "allPlayers", allPlayers );
        modelMap.put( "babich", babich );

        modelMap.addAttribute( ProjectConstants.CONTENT_KEY, ViewConstants.TEAM_VIEW );
        return "home";
    }
}
