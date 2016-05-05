package com.aug.jma.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profiel {
    @Autowired
    @Qualifier("student1")
    private Student student;
    
    public Profiel() {
        System.out.println("Execute Profiel construct method");
    }
    
    public void printName() {
        System.out.println("Student1 name " + student.getName());
    }
    
    public void printAge() {
        System.out.println("Student1 age " + student.getAge());
    }
}
