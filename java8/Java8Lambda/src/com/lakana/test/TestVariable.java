package com.lakana.test;

import com.lakana.module.Apple;

import java.awt.*;

/**
 * Created by Jeff.Ma on 3/7/2017.
 */
public class TestVariable {
    public static void main(String[] args){
        int varInt = 1;
        Runnable run = () -> {
            System.out.println(varInt);
        };
        Thread thread = new Thread(run);
        thread.start();

        final Apple apple1 = new Apple(1, Color.green, 100, "Good");
        Runnable run2 = () -> {
            System.out.println(apple1);
            apple1.setId(4);
        };
        apple1.setId(5);
        System.out.println(apple1.getId());
        Thread thread1 = new Thread(run2);
        thread1.run();
        System.out.println(apple1.getId());
    }
}
