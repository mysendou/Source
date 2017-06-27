package com.quatz.demo2;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class MyJob implements Job{

    @Override
    public void execute(JobExecutionContext jobContext) throws JobExecutionException {
        JobKey jobKey = jobContext.getJobDetail().getKey();
        System.out.println("jobKey " + jobKey + " ===== Date " + new Date());
    }

}
