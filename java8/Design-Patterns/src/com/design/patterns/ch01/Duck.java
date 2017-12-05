package com.design.patterns.ch01;

/**
 * Created by Jeff.Ma on 12/5/2017.
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack(){
        quackBehavior.quack();
        }
    public void swim(){
        System.out.println("Swim swim swim swim...");
    }
    public void performFly(){
        flyBehavior.fly();
    }
    public void display(){

    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
