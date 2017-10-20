package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.data.PlayersRepository;
import com.shylo.fcrespect.backend.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RespectController {

    @Autowired
    private PlayersRepository playersRepository;
    private static List<String> localeCodes = Arrays.asList( "en", "ru", "ua" );

    @RequestMapping( value = "/" )
    public String homePage( ModelMap modelMap ) {
        modelMap.put( ProjectConstants.LOCALE_CODES_KEY, localeCodes );

        modelMap.addAttribute( ProjectConstants.CONTENT_KEY, ViewConstants.HOME_VIEW );
        return "home";
    }


    @RequestMapping( value = "/team" )
    public String teamPage( ModelMap modelMap ) {
        List<Player> allPlayers = playersRepository.getAllPlayers();
        Player babich = playersRepository.getPlayerByImgName( "Babich" );
        modelMap.put( "allPlayers", allPlayers );
        modelMap.put( "babich", babich );

        modelMap.addAttribute( ProjectConstants.CONTENT_KEY, ViewConstants.TEAM_VIEW );
        return "home";
    }
}
