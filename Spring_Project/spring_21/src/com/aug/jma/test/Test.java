package com.aug.jma.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.dao.StudentDao;
import com.aug.jma.domain.StudentMarks;
import com.aug.jma.template.StudentTemplate;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDao studentTemplate = (StudentDao) context.getBean("studentTemplate");
        System.out.println("============= Insert data ==============");
        studentTemplate.create("Hubert", 21,90,2011);
        studentTemplate.create("Yolanda", 22,100,2012);
        studentTemplate.create("Jeff", 23,110,2013);
        
        System.out.println("================= Query All Student ================");
        List<StudentMarks> studentMarks = studentTemplate.getStudents();
        for (StudentMarks studentMark : studentMarks) {
            System.out.println(studentMark.toString());
        }
    }

}
