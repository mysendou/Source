package com.aug.jma.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.JavaCollection;

public class Test {
    @org.junit.Test
    public void TestCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JavaCollection collection = (JavaCollection) context.getBean("javaCollection");
        collection.getAddressList();
        collection.getAddressSet();
        collection.getAddressMap();
        collection.getAddressProperties();
    }
}
