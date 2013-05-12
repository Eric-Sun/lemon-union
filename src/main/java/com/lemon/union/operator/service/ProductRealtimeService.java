package com.lemon.union.operator.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.operator.dto.ProductRealtimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-4
 * Time: 下午10:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductRealtimeService {

    @Autowired
    IncomeDAO dao;

    public int queryCount(Date startTime, Date endTime, Integer wid, String mobile, String totalincome, String cmdid) {
        return dao.queryForProductRealTimeCount(startTime, endTime, wid, mobile, totalincome, cmdid);
    }

    public List<ProductRealtimeDTO> query(Date startTime, Date endTime, Integer wid, String mobile, String totalincome, String cmdid, int pageNum, int pageSize) {
        return dao.queryForProductRealTime(startTime, endTime, wid, mobile, totalincome, cmdid, pageNum, pageSize);
    }

    public String getLastMobile(String path, int count, HttpServletResponse response) throws IOException {
        String filePath = path + File.separator + "mobile_" + System.currentTimeMillis() + ".txt";
        FileWriter fw = new FileWriter(new File(filePath));
        List<Object[]> list = dao.getLastMobile(count);
        for (Object[] o : list) {
            fw.write(o[0].toString() + "\t" + o[1].toString() + "\r\n");
        }
        fw.close();
        FileInputStream fis = new FileInputStream(new File(filePath));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        OutputStream os = response.getOutputStream();
        os.write(buffer);
        os.close();
        return filePath;
    }
}
