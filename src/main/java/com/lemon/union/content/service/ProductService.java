package com.lemon.union.content.service;

import com.lemon.union.content.dto.ProductDTO;
import com.lemon.union.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 上午12:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductService {

    @Autowired
    ProductDAO dao;

    public List<ProductDTO> list() {
        return dao.list();
    }

    public void update(long pid, String name, String thumbnail, String brief, String commission, int status) {
        dao.update(pid, name, thumbnail, brief, commission, status);
    }

    public void create(String name, String thumbnail, String brief, String commission, int status) {
        dao.create(name, thumbnail, brief, commission, status);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public ProductDTO show(long id) {
        return dao.show(id);
    }
}
