package com.aug.jma.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aug.jma.domain.Student;
import com.aug.jma.template.StudentTemplate;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentTemplate studentTemplate = (StudentTemplate) context.getBean("studentTemplate");
        System.out.println("============= Insert data ==============");
        studentTemplate.create("Ricky", 21);
        studentTemplate.create("Dillon", 22);
        studentTemplate.create("Jack", 23);
        
        System.out.println("================= Query All Student ================");
        List<Student> students = studentTemplate.getStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        
        System.out.println("=============== Update the student id = 2 ================");
        studentTemplate.updateStudent(2, 1);
        
        System.out.println("================ Query Student id = 2 =================");
        Student student = studentTemplate.getStudent(2);
        System.out.println(student.toString());
    }

}
