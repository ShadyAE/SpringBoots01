package com.shi.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Myjob01 implements Job {
    private Logger log = LoggerFactory.getLogger(Myjob01.class);


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TriggerKey triggerKey = context.getTrigger().getKey();
        log.info("触发器:"+triggerKey.getName()+"-->所属组:"+triggerKey.getGroup()+"-->"+sdf.format(new Date())+"-->"+"hello Spring BootQuartz...");
    }
}
