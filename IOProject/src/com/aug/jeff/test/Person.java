package com.aug.jeff.test;

import java.io.Serializable;

public class Person implements Serializable{
    private String name;
    private int number;

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", number=" + number + "]";
    }

}
