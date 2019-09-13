package com.shylo.fcrespect.backend.dao;

import com.shylo.fcrespect.backend.dao.impl.PlayerDaoImpl;
import com.shylo.fcrespect.backend.dao.impl.PositionDaoImpl;
import com.shylo.fcrespect.backend.dao.impl.StatisticDaoImpl;
import com.shylo.fcrespect.backend.enums.PositionValue;
import com.shylo.fcrespect.backend.model.Player;
import com.shylo.fcrespect.backend.model.Position;
import com.shylo.fcrespect.backend.model.Statistic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PlayerDaoTest {

    @Autowired
    PlayerDaoImpl playerDao;

    @Autowired
    PositionDaoImpl positionDao;

    @Autowired
    StatisticDaoImpl statisticDao;

    @Test
    public void createPlayerTest() {
        Player player = getPlayer();
        playerDao.create(player);
        Player playerFromDB = playerDao.findOne(player.getId()).orElse(null);

        assertEquals(player, playerFromDB);
    }

    @Test
    public void deleteByIdPlayerTest() {
        Player player = getPlayer();
        playerDao.create(player);
        Player playerFromDB = playerDao.findOne(player.getId()).orElse(null);
        assertEquals(player, playerFromDB);

        playerDao.deleteById(player.getId());
        Player deletedPlayer = playerDao.findOne(player.getId()).orElseGet(() -> null);
        assertNull(deletedPlayer);
    }

    @Test
    public void getPlayerByEntityTest() {
        Player player = getPlayer();
        playerDao.create(player);
        Player playerFromDB = playerDao.findOne(player.getId()).orElse(null);
        assertEquals(player, playerFromDB);

        playerDao.delete(player);
        Player deletedPlayer = playerDao.findOne(player.getId()).orElseGet(() -> null);
        assertNull(deletedPlayer);
    }

    @Test
    public void getAllPlayerTest() {
        int playersSizeBefore = playerDao.findAll().size();
        Player player = getPlayer();
        playerDao.create(player);

        int playersSizeAfter = playerDao.findAll().size();

        assertEquals(playersSizeAfter - playersSizeBefore, 1);
    }

    @Test
    public void updatePlayerTest() {
        int playerId = 1;
        Player player = getPlayer();
        player.setId(playerId);

        Player updatable = playerDao.findOne(playerId).orElseGet(() -> null);
        assertNotNull(updatable);
        player.getStatistic().setId(updatable.getStatistic().getId());
        assertNotEquals(player, updatable);

        playerDao.update(player);
        Player playerAfterUpdate = playerDao.findOne(playerId).orElseGet(() -> null);

        assertEquals(player, playerAfterUpdate);

    }

    private Player getPlayer() {
        final Position positionFromDB = positionDao.findOne(1).orElse(new Position(1, PositionValue.DEFENDER.getValue()));
        Statistic statistic = new Statistic();

        Player player = new Player();
        player.setFullName("Test player");
        player.setBirthday(LocalDate.of(1985, Month.DECEMBER, 31));
        player.setAbout("TestAbout");
        player.setHeight(170);
        player.setImageName("someImgName");
        player.setPosition(positionFromDB);
        player.setStatistic(statistic);
        return player;
    }

}
