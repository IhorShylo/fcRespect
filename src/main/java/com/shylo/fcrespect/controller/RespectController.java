package com.shylo.fcrespect.controller;

import com.shylo.fcrespect.data.PlayersRepository;
import com.shylo.fcrespect.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class RespectController {

    @Autowired
    private PlayersRepository playersRepository;

    @RequestMapping(value = "/")
    public String homePage(ModelMap modelMap) {
        Player player = playersRepository.getPlayerByImgName("Den");
        modelMap.put("player", player);
        return "home";
    }


    @RequestMapping(value = "/players")
    @ResponseBody
    public String listOfPlayers() {
        return "List of Players";
    }
}
