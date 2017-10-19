package com.shylo.fcrespect.controller;

import com.shylo.fcrespect.data.PlayersRepository;
import com.shylo.fcrespect.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
public class RespectController {

    @Autowired
    private PlayersRepository playersRepository;
    private static List<String> localeCodes = Arrays.asList( "en", "ru", "ua" );

    @RequestMapping( value = "/" )
    public String homePage( ModelMap modelMap ) {
        modelMap.put( "localeCodes", localeCodes );
        modelMap.put( "today", Calendar.getInstance() );
        return "home";
    }


    @RequestMapping( value = "/team" )
    public String teamPage( ModelMap modelMap ) {
        List<Player> allPlayers = playersRepository.getAllPlayers();
        Player babich = playersRepository.getPlayerByImgName( "Babich" );
        modelMap.put( "allPlayers", allPlayers );
        modelMap.put( "babich", babich );
        return "team";
    }
}
