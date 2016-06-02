package com.aug.jeff.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.stream.StreamSource;

import com.aug.jeff.dto.domain.Country;
import com.aug.jeff.dto.domain.Province;
import com.aug.jeff.dto.Story;
import com.aug.jeff.dto.domain.Book;
import com.aug.jeff.dto.domain.Role;
import com.aug.jeff.dto.domain.Student;
import com.aug.jeff.util.JAXBXMLHandler;

public class Test {

    @org.junit.Test
    public void test1() {
        Story story = new Story();
        story.setId("1");
        StringBuffer sb = new StringBuffer();
        sb.append("story body");
        story.setBody(sb.toString());
        Map<String, StreamSource> oxm = new HashMap<String, StreamSource>(1);
        oxm.put("com.aug.jeff.dto", new StreamSource("storyMapping.xml"));
        Map<String, Map<String, StreamSource>> properties = new HashMap<String, Map<String, StreamSource>>();
        properties.put("eclipselink-oxm-xml", oxm);
        Class[] classes = { Story.class };

        JAXBXMLHandler.marshal(story, classes, properties, new File("story.xml"));
        Story story2 = JAXBXMLHandler.unmarshal(new File("story.xml"));
        System.out.println("Unmarshal: " + story2);
    }

    @org.junit.Test
    public void test2() {
        Book book = new Book();
        book.setId(100);
        book.setAuthor("James");
        book.setCalendar(new Date());
        book.setPrice(23.45f); // 默认是0.0

        Map<String, StreamSource> oxm = new HashMap<String, StreamSource>(1);
        oxm.put("com.aug.jeff.dto.domain", new StreamSource("bookMapping.xml"));
        Map<String, Map<String, StreamSource>> properties = new HashMap<String, Map<String, StreamSource>>();
        properties.put("eclipselink-oxm-xml", oxm);
        Class[] classes = { Book.class };

        JAXBXMLHandler.marshal(book, classes, properties, new File("book.xml"));
        // Story story2 = JAXBXMLHandler.unmarshal(new File("story.xml"));
        // System.out.println("Unmarshal: " + story2);
    }

    @org.junit.Test
    public void test3() {
        Student student = new Student();
        student.setId(12);
        student.setName("test");

        Role role = new Role();
        role.setDesc("管理");
        role.setName("班长");

        student.setRole(role);

        Map<String, StreamSource> oxm = new HashMap<String, StreamSource>(1);
        oxm.put("com.aug.jeff.dto.domain", new StreamSource("studentMapping.xml"));
        Map<String, Map<String, StreamSource>> properties = new HashMap<String, Map<String, StreamSource>>();
        properties.put("eclipselink-oxm-xml", oxm);
        Class[] classes = { Student.class };

        JAXBXMLHandler.marshal(student, classes, properties, new File("student.xml"));
    }

    @org.junit.Test
    public void test4() {
        Country country = new Country();
        country.setName("中国");

        List<Province> list = new ArrayList<Province>();
        Province province = new Province();
        province.setName("江苏省");
        province.setProvCity("南京市");
        Province province2 = new Province();
        province2.setName("浙江省");
        province2.setProvCity("杭州市");
        list.add(province);
        list.add(province2);

        country.setProvinces(list);
        
        Map<String, StreamSource> oxm = new HashMap<String, StreamSource>(1);
        oxm.put("com.aug.jeff.dto.domain", new StreamSource("countryMapping.xml"));
        Map<String, Map<String, StreamSource>> properties = new HashMap<String, Map<String,StreamSource>>();
        properties.put("eclipselink-oxm-xml", oxm);
        Class[] classes = {Country.class};
        
        JAXBXMLHandler.marshal(country, classes, properties, new File("country.xml"));
    }
}
