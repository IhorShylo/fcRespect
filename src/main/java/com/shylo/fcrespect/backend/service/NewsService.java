package com.shylo.fcrespect.backend.service;

import com.shylo.fcrespect.backend.dto.req.news.NewsCreateRequest;
import com.shylo.fcrespect.backend.dto.req.news.NewsUpdateRequest;
import com.shylo.fcrespect.backend.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    News createNews(NewsCreateRequest req);

    News updateNews(NewsUpdateRequest req);

    void deleteNewsById(Integer id);

    Optional<News> findNews(Integer id);

    List<News> findAllNews();

}
