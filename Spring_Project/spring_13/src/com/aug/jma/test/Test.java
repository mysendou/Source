package com.aug.jma.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aug.jma.config.HelloWorldConfig;
import com.aug.jma.domain.HelloWorld;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                HelloWorldConfig.class);
        //对应的是 HelloWorldConfig 类中获取对象的方法名
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld1");
        helloWorld.setMessage("hello");
        System.out.println(helloWorld.getMessage());
    }
}
