package com.lemon.union.content.service;

import com.lemon.union.content.dto.WebownerDTO;
import com.lemon.union.dao.WebownerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 下午10:44
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WebownerService {

    @Autowired
    WebownerDAO dao;

    public List<WebownerDTO> list() {
        return dao.list();
    }

    public void update(long wid, String truename, String mobile, String telephone, String address, String qq, String sitename,
                       String siteurl, String sitetype, String bankaddr, String bankcard, String account, Date regtime, String channel,
                       String remark, int msgCount) {
        dao.update(
                wid, truename, mobile, telephone, address, qq, sitename,
                siteurl, sitetype, bankaddr, bankcard, account, regtime, channel,
                remark, msgCount);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public WebownerDTO show(long id) {
        return dao.show(id);
    }

    public void pass(long wid) {
        dao.setStatus(wid, 1);
    }

    public void stop(long wid) {
        dao.setStatus(wid, 3);
    }

    public void notpass(long wid) {
        dao.setStatus(wid, 2);
    }

    public void resume(long wid) {
        dao.setStatus(wid, 1);
    }
}
