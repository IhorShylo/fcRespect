package com.shylo.fcrespect.backend.dao.impl;

import com.shylo.fcrespect.backend.dao.AbstractJpaDAO;
import com.shylo.fcrespect.backend.dao.IPlayerDao;
import com.shylo.fcrespect.backend.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao extends AbstractJpaDAO<Player> implements IPlayerDao {

    public PlayerDao() {
        setClazz( Player.class );
    }
}
