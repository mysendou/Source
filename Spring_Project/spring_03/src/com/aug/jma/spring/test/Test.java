package com.aug.jma.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.spring.HelloWorldC;
import com.aug.jma.spring.HelloWorldF;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");

        // HelloWorldF helloWorldF = (HelloWorldF) context.getBean("helloF");
        // helloWorldF.getMessage1();
        //       helloWorldF.getMessage2();
        
        HelloWorldC helloWorldC = (HelloWorldC) context.getBean("helloC");
        helloWorldC.getMessage1();
        helloWorldC.getMessage2();
        helloWorldC.getMessage3();
    }
}
