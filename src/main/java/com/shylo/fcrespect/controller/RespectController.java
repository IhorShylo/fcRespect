package com.shylo.fcrespect.controller;

import com.shylo.fcrespect.model.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class RespectController {

    @RequestMapping(value = "/")
    public String homePage(ModelMap modelMap){
        Player player = new Player("Шило Игорь", LocalDate.of(1989, 12, 2), "Defender", "Tolik");
        modelMap.put("player", player);
        return "home";
    }


    @RequestMapping(value = "/players")
    @ResponseBody
    public String listOfPlayers(){
        return "List of Players";
    }
}
