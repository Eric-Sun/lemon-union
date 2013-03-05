package com.lemon.union.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DayUpdateJob extends QuartzJobBean {

    private AnalyserIncome income;
    Logger log = LoggerFactory.getLogger(getClass());
    private boolean run = true;

    public void setRun(boolean run) {
        this.run = run;
    }


    public AnalyserIncome getIncome() {
        return income;
    }

    public void setIncome(AnalyserIncome income) {
        this.income = income;
    }

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if (this.run) {

            Map dataMap = context.getJobDetail().getJobDataMap();
            ApplicationContext ctx = (ApplicationContext)dataMap.get("applicationContext");
            Calendar ca = Calendar.getInstance();
            ca.add(Calendar.DAY_OF_YEAR, -1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String subdate = sdf.format(ca.getTime());
            boolean flag = executeProcedure(ctx,subdate);
            if (!flag)
                this.log.error(context.getJobDetail().getName() + "," + subdate + ": failed!");
            else
                this.log.info(context.getJobDetail().getName() + "," + subdate + ": successed!");
        }
    }

    private boolean executeProcedure(ApplicationContext ctxt, String subdate) {
        try {
            try {
                income = ctxt.getBean(AnalyserIncome.class);
                income.analyze(subdate);
            } catch (Exception e) {
                this.log.error("dayjob AnalyzeChannelIncome error:", e);
                return false;
            }
        } catch (Exception e) {
            this.log.error(getClass().getName() + " error:", e);
            return false;
        }
        return true;
    }
}