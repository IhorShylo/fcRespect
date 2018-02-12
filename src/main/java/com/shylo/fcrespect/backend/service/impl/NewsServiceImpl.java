package com.shylo.fcrespect.backend.service.impl;

import com.shylo.fcrespect.backend.dao.impl.NewsDaoImpl;
import com.shylo.fcrespect.backend.dto.req.news.NewsCreateRequest;
import com.shylo.fcrespect.backend.dto.req.news.NewsUpdateRequest;
import com.shylo.fcrespect.backend.model.News;
import com.shylo.fcrespect.backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsDaoImpl newsDao;

    @Autowired
    public NewsServiceImpl(NewsDaoImpl newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public News createNews(NewsCreateRequest req) {
        throw new NotImplementedException();
    }

    @Override
    public News updateNews(NewsUpdateRequest req) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteNewsById(Integer id) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<News> findNews(Integer id) {
        return newsDao.findOne(id);
    }

    @Override
    public List<News> findAllNews() {
        return newsDao.findAll();
    }
}
