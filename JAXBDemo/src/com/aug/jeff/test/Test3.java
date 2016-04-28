package com.aug.jeff.test;

import org.junit.Test;

import com.aug.jeff.dto.Role;
import com.aug.jeff.dto.Student;
import com.aug.jeff.util.JaxbUtil;

public class Test3 {
    @Test
    public void showMarshaller() {
        Student student = new Student();
        student.setId(12);
        student.setName("test");

        Role role = new Role();
        role.setDesc("管理");
        role.setName("班长");
        
        student.setRole(role);
        
        String str = JaxbUtil.convertBeanToXml(student);
        System.out.println(str);
    }
    
    @Test  
    public void showUnMarshaller() {  
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+  
            "<student id=\"2\">"+  
            "    <name>Jeff</name>"+  
             "   <role>"+  
              "      <name>员工</name>"+  
               "     <desc>编码,学习</desc>"+  
                "</role>"+  
            "</student>";  
        Student student = JaxbUtil.convertXmlToBean(str, Student.class);  
        System.out.println(student);  
    }  
}
