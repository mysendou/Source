package com.lakana.methodreference.construct.module;

/**
 * Created by Jeff.Ma on 1/18/2017.
 */
public class Animal {
    private String name;
    private int age;

    public Animal (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal (String name) {
        this.name = name;
    }

    public Animal(){

    }
    public void behavior () {

    }

    @Override
    public String toString () {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
