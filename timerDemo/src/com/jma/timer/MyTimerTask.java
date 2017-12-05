package com.jma.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Jeff.Ma on 10/18/2017.
 */
public class MyTimerTask extends TimerTask {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTimerTask(String name){
        this.name = name;
    }


    @Override
    public void run() {
        Date date = new Date();
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        String format = bf.format(date);
        System.out.println(format);

        System.out.println("Task name: " + name);
    }
}
