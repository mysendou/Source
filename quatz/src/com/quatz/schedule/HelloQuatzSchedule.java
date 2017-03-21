package com.quatz.schedule;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.quatz.job.HelloQuatzJob;

public class HelloQuatzSchedule {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob().ofType(HelloQuatzJob.class).usingJobData("name", "Hello Quatz Job").build();
        
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).forJob(jobDetail).startNow().build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
