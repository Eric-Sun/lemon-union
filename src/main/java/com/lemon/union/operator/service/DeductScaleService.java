package com.lemon.union.operator.service;

import com.lemon.union.operator.dto.DeductScaleDTO;
import com.lemon.union.dao.DeductScaleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 下午6:51
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DeductScaleService {

    @Autowired
    DeductScaleDAO dao;

    public List<DeductScaleDTO> list() {
        return dao.list();
    }

    public void create(long wid, long pid, int offbase, int offno, int status) {
        dao.create(wid, pid, offbase, offno, status);
    }

    public void update(long id, long wid, long pid, int offbase, int offno, int status) {
        dao.update(id, wid, pid, offbase, offno, status);
    }

    public DeductScaleDTO show(long id) {
        return dao.show(id);
    }

    public void delete(long id) {
        dao.delete(id);
    }

}
