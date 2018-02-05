package com.shylo.fcrespect.backend.dao.impl;

import com.shylo.fcrespect.backend.dao.AbstractJpaDAO;
import com.shylo.fcrespect.backend.dao.StatisticDao;
import com.shylo.fcrespect.backend.model.Statistic;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticDaoImpl extends AbstractJpaDAO<Statistic> implements StatisticDao {

    public StatisticDaoImpl() {
        setClazz(Statistic.class);
    }
}
