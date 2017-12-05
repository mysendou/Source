package com.jma.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Jeff.Ma on 10/18/2017.
 */
public class TimeTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new MyTimerTask("TimeTasker1");
        Date date = new Date();

        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        String format = bf.format(date);
        System.out.println(format);
        timer.schedule(timerTask,5000L);
    }
}
