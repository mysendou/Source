package com.aug.jma.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.domain.HelloWorld;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "beans.xml");
        HelloWorld hello = (HelloWorld) context.getBean("helloworld");
        hello.getMessage();
        context.registerShutdownHook();
    }
}
