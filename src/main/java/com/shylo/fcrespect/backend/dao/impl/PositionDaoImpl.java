package com.shylo.fcrespect.backend.dao.impl;

import com.shylo.fcrespect.backend.dao.AbstractJpaDAO;
import com.shylo.fcrespect.backend.dao.PositionDao;
import com.shylo.fcrespect.backend.model.Position;
import org.springframework.stereotype.Repository;

@Repository
public class PositionDaoImpl extends AbstractJpaDAO<Position> implements PositionDao {

    public PositionDaoImpl() {
        setClazz(Position.class);
    }
}
