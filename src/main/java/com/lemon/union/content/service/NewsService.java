package com.lemon.union.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.union.content.dto.LemNewsDTO;
import com.lemon.union.dao.LemNewsDAO;

@Service
public class NewsService {

    @Autowired
    LemNewsDAO dao;

    public List<LemNewsDTO> list(int pageNum, int pageSize) {
        return dao.list(pageNum, pageSize);
    }

    public int count() {
        return dao.count();
    }

    public void create(String catalogid, String classid, String title,
                       String brief, String content, String orign, String editor,
                       String link) {
        dao.create(catalogid, classid, title, brief, content, orign, editor,
                link);
    }

    public void update(long id, String catalogid, String classid, String title,
                       String brief, String content, String orign, String editor,
                       String link) {
        dao.update(id, catalogid, classid, title, brief, content, orign,
                editor, link);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public LemNewsDTO show(int id) {
        return dao.show(id);
    }
}
