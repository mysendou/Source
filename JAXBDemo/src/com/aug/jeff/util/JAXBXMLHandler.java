package com.aug.jeff.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.aug.jeff.dto.Story;

public class JAXBXMLHandler {
    public static Story unmarshal(File impoFile){
        Story story = new Story();
        JAXBContext jc;
        
        try {
            jc = JAXBContext.newInstance(Story.class);
            Unmarshaller um = jc.createUnmarshaller();
            story = (Story) um.unmarshal(impoFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return story;
    }
    
    public static void marshal(Object o, Class[] classes,  Map<String, Map<String, StreamSource>> properties, File selectedFile){
        JAXBContext jc;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(selectedFile));
            jc = JAXBContext.newInstance(classes, properties);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(o, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
