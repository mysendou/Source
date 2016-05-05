package com.aug.jma.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.domain.Profiel;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Profiel profiel = (Profiel) context.getBean("profile");
        profiel.printName();
        profiel.printAge();
    }
}
