package com.shylo.fcrespect.controller;

import com.shylo.fcrespect.data.PlayersRepository;
import com.shylo.fcrespect.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RespectController {

    @Autowired
    private PlayersRepository playersRepository;

    @RequestMapping(value = "/")
    public String homePage(ModelMap modelMap) {
        return "home";
    }


    @RequestMapping(value = "/team")
    public String teamPage(ModelMap modelMap) {
        List<Player> allPlayers = playersRepository.getAllPlayers();
        modelMap.put("allPlayers", allPlayers);
        return "team";
    }
}
