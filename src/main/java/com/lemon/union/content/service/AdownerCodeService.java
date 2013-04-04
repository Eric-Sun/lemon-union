package com.lemon.union.content.service;

import com.lemon.union.content.dto.AdownerCodeDTO;

import java.util.List;

import com.lemon.union.dao.AdownerCodeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-24
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AdownerCodeService {

    @Autowired
    AdownerCodeDAO dao;

    public List<AdownerCodeDTO> list() {
        return dao.list();
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public void update(long id, long adownerid, long pid, String servicecode, String servicename, String servicefee, String ownerfee,
                       String ordercode, String orderdest, String brief, String offnum,
                       String offbase, String servicephone, String remark) {
        dao.update(id, adownerid, pid, servicecode, servicename, servicefee, ownerfee, ordercode,
                orderdest, brief, offnum, offbase, servicephone, remark);
    }

    public void create(long adownerid, long pid, String servicecode, String servicename, String servicefee, String ownerfee,
                       String ordercode, String orderdest,
                       String brief, String offnum, String offbase, String servicephone, String
            remark) {
        dao.create(adownerid, pid, servicecode, servicename, servicefee, ownerfee, ordercode,
                orderdest, brief, offnum, offbase, servicephone, remark);
    }

    public AdownerCodeDTO show(long id) {
        return dao.show(id);
    }
}
