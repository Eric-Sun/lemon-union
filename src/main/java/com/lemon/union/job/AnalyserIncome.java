package com.lemon.union.job;

import com.lemon.union.dao.SchedulerJobDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-4
 * Time: 下午6:48
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AnalyserIncome {

    @Autowired
    SchedulerJobDAO dao;


    public void analyze(String subdate) {
    }
}
