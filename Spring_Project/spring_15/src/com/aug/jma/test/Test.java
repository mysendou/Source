package com.aug.jma.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.domain.HelloWorld;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.start();
        HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
        hw.getMessage();
        context.stop();
    }
}
