package com.shylo.fcrespect.backend.dao.impl;

import com.shylo.fcrespect.backend.dao.AbstractJpaDAO;
import com.shylo.fcrespect.backend.dao.PlayerDao;
import com.shylo.fcrespect.backend.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDaoImpl extends AbstractJpaDAO<Player> implements PlayerDao {

    public PlayerDaoImpl() {
        setClazz( Player.class );
    }
}
