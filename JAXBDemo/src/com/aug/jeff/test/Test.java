package com.aug.jeff.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.stream.StreamSource;

import com.aug.jeff.dto.Story;
import com.aug.jeff.util.JAXBXMLHandler;

public class Test {
    public static void main(String[] args) {
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

        JAXBXMLHandler.marshal(story, classes, properties,
                new File("story.xml"));
        Story story2 = JAXBXMLHandler.unmarshal(new File("story.xml"));
        System.out.println("Unmarshal: " + story2);
    }
}
