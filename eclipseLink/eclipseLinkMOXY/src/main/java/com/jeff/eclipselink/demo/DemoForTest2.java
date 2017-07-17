package com.jeff.eclipselink.demo;

import com.jeff.eclipselink.module.OBFeedEntry;
import com.jeff.eclipselink.module.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jeff.Ma on 7/13/2017.
 */
public class DemoForTest2 {
    public static void main (String[] args) throws Exception{
        // Step 1 - Create the Domain Model
        User user = new User();
        user.setFirstName("First Name");
        user.setLastName("Last Name");
        OBFeedEntry obFeedEntry = new OBFeedEntry();
        obFeedEntry.put("name", "First Name");
        List embedObjects = new ArrayList();
        embedObjects.add(obFeedEntry);

        user.put("embedObjects", embedObjects);

        Map<String, Source> metadata = new HashMap<String, Source>();
        metadata.put("com.jeff.eclipselink.module", new StreamSource("user-mapping.xml"));

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("eclipselink-oxm-xml", metadata);

        Class[] classes = new Class[1];
        classes[0] = User.class;

        JAXBContext jaxbContext = JAXBContext.newInstance(classes, properties);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(user, System.out);
    }
}
