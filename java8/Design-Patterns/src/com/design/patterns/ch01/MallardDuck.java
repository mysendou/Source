package com.design.patterns.ch01;

/**
 * Created by Jeff.Ma on 12/5/2017.
 */
public class MallardDuck extends Duck{

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void swim() {

    }

    public void display() {
        System.out.println("I'm a green head duck");
    }
}
