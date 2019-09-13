package com.shylo.fcrespect.backend.dao;

import com.shylo.fcrespect.backend.dao.impl.StatisticDaoImpl;
import com.shylo.fcrespect.backend.model.Statistic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StatisticDaoTest {

    @Autowired
    StatisticDaoImpl statisticDao;

    @Test
    public void saveStatisticTest() {

        Statistic statistic = new Statistic();
        statisticDao.create(statistic);
        Statistic statisticFromDB = statisticDao.findOne(statistic.getId()).orElseGet(() -> null);

        assertEquals(statistic, statisticFromDB);
    }
}
