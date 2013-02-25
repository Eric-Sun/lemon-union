package com.lemon.union.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.union.content.dto.LemCatalogDTO;
import com.lemon.union.dao.LemCatalogDAO;

@Service
public class CatalogService {
    @Autowired
    private LemCatalogDAO dao;

    public List<LemCatalogDTO> list() {
        return dao.listAll();
    }

    public LemCatalogDTO show(long id) {
        return dao.show(id);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public void create(String id, String parentid, String classid, String name, String isleaf, String orders) {
        dao.create(id, parentid, classid, name, isleaf, orders);
    }

    public void update(String id, String parentid, String classid, String name, String isleaf, String orders) {
        dao.update(id, parentid, classid, name, isleaf, orders);
    }
}
