package com.shylo.fcrespect.backend.controller;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.dao.impl.PlayerDaoImpl;
import com.shylo.fcrespect.backend.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/team")
public class TeamController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    PlayerDaoImpl playerDao;

    @RequestMapping
    public String teamPage(ModelMap modelMap, HttpServletRequest request) {
        LOGGER.info("Enter in url- {}", request.getRequestURL());
        List<Player> allPlayers = playerDao.findAll();
        modelMap.put("allPlayers", allPlayers);
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.TEAM_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }

    @RequestMapping(value = "/{id}")
    public String playerDetailPage(ModelMap modelMap, @PathVariable int id, HttpServletRequest request) {
        LOGGER.info("Enter in url- {}", request.getRequestURL());

        Player player = playerDao.findOne(id).orElseThrow(IllegalArgumentException::new);
        modelMap.put("player", player);
        modelMap.addAttribute(ProjectConstants.CONTENT_KEY, ViewConstants.PLAYER_DETAILS_VIEW);
        return ProjectConstants.HOME_PAGE_KEY;
    }
}
