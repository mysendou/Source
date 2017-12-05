package com.design.patterns.ch01;

/**
 * Created by Jeff.Ma on 12/5/2017.
 */
public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
