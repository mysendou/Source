package com.design.patterns.ch01;

/**
 * Created by Jeff.Ma on 12/5/2017.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
