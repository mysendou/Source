package com.quatz.demo1;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * A simple job that says Hello World
 * @author Jeff.Ma
 *
 */
public class HelloJob implements Job{

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Hello World! - " + new Date());
    }
    
}
