package com.shylo.fcrespect.backend.service.impl;

import com.shylo.fcrespect.backend.dao.impl.PlayerDaoImpl;
import com.shylo.fcrespect.backend.dao.impl.PositionDaoImpl;
import com.shylo.fcrespect.backend.dao.impl.StatisticDaoImpl;
import com.shylo.fcrespect.backend.dto.req.player.PlayerCreateRequest;
import com.shylo.fcrespect.backend.dto.req.player.PlayerUpdateRequest;
import com.shylo.fcrespect.backend.model.Player;
import com.shylo.fcrespect.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerDaoImpl playerDao;

    private final StatisticDaoImpl statisticDao;

    private final PositionDaoImpl positionDao;

    @Autowired
    PlayerServiceImpl(PlayerDaoImpl playerDao, StatisticDaoImpl statisticDao, PositionDaoImpl positionDao) {
        this.playerDao = playerDao;
        this.statisticDao = statisticDao;
        this.positionDao = positionDao;
    }

    @Override
    public void createPlayer(PlayerCreateRequest request) {
        throw new NotImplementedException();
    }

    @Override
    public void updatePlayer(PlayerUpdateRequest request) {
        throw new NotImplementedException();
    }

    @Override
    public void deletePlayerById(Integer id) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<Player> findPlayer(Integer id) {
        return playerDao.findOne(id);
    }

    @Override
    public List<Player> findAllPlayer() {
        return playerDao.findAll();
    }
}
