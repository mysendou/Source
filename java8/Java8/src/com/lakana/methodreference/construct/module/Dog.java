package com.lakana.methodreference.construct.module;

/**
 * Created by Jeff.Ma on 1/18/2017.
 */
public class Dog extends Animal{
    public Dog (String name, int age) {
        super(name, age);
    }

    public  Dog(){};

    public Dog (String name) {
        super(name);
    }

    @Override
    public void behavior () {
        System.out.println("run");
    }

}
