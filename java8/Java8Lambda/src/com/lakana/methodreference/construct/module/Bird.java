package com.lakana.methodreference.construct.module;

/**
 * Created by Jeff.Ma on 1/18/2017.
 */
public class Bird extends Animal {
    public Bird (String name, int age) {
        super(name, age);
    }

    @Override
    public void behavior () {
        System.out.println("Fly");
    }
}
