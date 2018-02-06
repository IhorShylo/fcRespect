package com.shylo.fcrespect.backend.dao;

import com.shylo.fcrespect.backend.dao.impl.NewsDaoImpl;
import com.shylo.fcrespect.backend.model.News;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NewsDaoTest {

    @Autowired
    NewsDaoImpl newsDao;

    private News news;

    private final String TITLE = "Default Title";
    private final String TEXT = "\n" +
            "                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta dolorem dolores ducimus expedita facere\n" +
            "                fugit maiores obcaecati odio. Accusantium amet aperiam explicabo laboriosam magnam quod? Alias obcaecati\n" +
            "                omnis tempore voluptatibus.\n" +
            "            ";

    @Before
    public void init() {
         news = News.builder()
                .title(TITLE)
                .creationTime(LocalDateTime.now())
                .text(TEXT)
                .build();
    }

    @Test
    public void createNewsTest() {
        System.out.println("News id before create= " + news.getId());
        newsDao.create(news);
        System.out.println("News id after create= " + news.getId());
        News newsFromDB = newsDao.findOne(news.getId()).orElseThrow(EntityNotFoundException::new);
        System.out.println("News id from db = " + newsFromDB.getId());

    }
}
