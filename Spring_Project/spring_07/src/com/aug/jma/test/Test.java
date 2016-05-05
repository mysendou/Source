package com.aug.jma.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.domain.TextEditor;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        TextEditor editor = (TextEditor) context.getBean("textEditor");
        editor.spellCheck();
    }
}
