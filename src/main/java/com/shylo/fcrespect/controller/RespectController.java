package com.shylo.fcrespect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RespectController {

    @RequestMapping(value = "/")
    public String homePage(){
        return "home";
    }


    @RequestMapping(value = "/players")
    @ResponseBody
    public String listOfPlayers(){
        return "List of Players";
    }
}
