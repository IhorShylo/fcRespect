package com.shylo.fcrespect.backend.dao.impl;

import com.shylo.fcrespect.backend.dao.AbstractJpaDAO;
import com.shylo.fcrespect.backend.dao.NewsDao;
import com.shylo.fcrespect.backend.model.News;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends AbstractJpaDAO<News> implements NewsDao {

    public NewsDaoImpl() {
        setClazz(News.class);
    }
}
