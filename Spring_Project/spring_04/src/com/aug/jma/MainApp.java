package com.aug.jma;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
//        textEditor.spellCheck();
        Demo1 demo1 = (Demo1) context.getBean("demo1");
        System.out.println(demo1.toString());
    }
}
