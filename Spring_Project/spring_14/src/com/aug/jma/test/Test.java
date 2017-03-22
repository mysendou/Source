package com.aug.jma.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aug.jma.config.ConfigB;
import com.aug.jma.domain.B;
import com.aug.jma.domain.TextEditor;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
        B b = context.getBean(B.class);
        
    }
}
