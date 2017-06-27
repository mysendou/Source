package com.quatz.demo2;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class Example {
    public static void main(String[] args) throws Exception {
        Example example = new Example();
        example.run();
    }

    private void run() throws Exception {
        // Create Schedule
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
        System.out.println("current time " + new Date());
        System.out.println("startTime: " + startTime);

        // Create job1 and put into group1
        JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();
        // Create trigger1 and put into group1
        SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger1", "group1").startAt(startTime).build();

        Date ft = scheduler.scheduleJob(job, trigger);

        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

        job = newJob(MyJob.class).withIdentity("job2", "group1").build();

        trigger = (SimpleTrigger) newTrigger().withIdentity("trigger2", "group1").startAt(startTime).build();

        ft = scheduler.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

        job = newJob(MyJob.class).withIdentity("job3", "group1").build();

        // Set the trigger repeat every 10 seconds and repeat 10 times
        trigger = (SimpleTrigger) newTrigger().withIdentity("trigger3", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10)).build();

        ft = scheduler.scheduleJob(job, trigger);

        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

        trigger = (SimpleTrigger) newTrigger().withIdentity("trigger3", "group2").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(2)).forJob(job).build();

        ft = scheduler.scheduleJob(trigger);

        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

        scheduler.start();
        
        Thread.sleep(30L*1000);
        SchedulerMetaData metaData = scheduler.getMetaData();
        System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
    }
}
