package com.aug.jma.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("hello2");
        helloWorld.setMessage("Jeff");
        helloWorld.getMessage();
        HelloWorld helloWorld2 = (HelloWorld)context.getBean("hello2");
        helloWorld2.getMessage();
    }
}
