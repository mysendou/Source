package com.quatz.demo1;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Example1 {
    public static void main(String[] args) throws Exception {
        Example1 example1 = new Example1();
        example1.run();
    }

    private void run() throws Exception {
        System.out.println("------- Initializing ----------------------");
        // Use the SchedulerFactory to create the Schedule
        Scheduler sched = new StdSchedulerFactory().getScheduler();

        sched.start();
        JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

        // compute a time that is on the next round minute
        Date runTime = evenMinuteDate(new Date());
        System.out.println("------- runTime ----------------------" + runTime);

        // Trigger the job to run on the next round minute
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);

        sched.start();

        try {
            // wait 65 seconds to show job
            Thread.sleep(65L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }
    }
}
