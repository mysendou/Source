package com.jeff.eclipselink.demo;

import com.jeff.eclipselink.module.*;

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
public class DemoForTest {
    public static void main (String[] args) throws  Exception{
        // Step 1 - Create the Domain Model

        Customer customer = new Customer();
        customer.setName("Jane Doe");

        Address address = new Address();
        address.setStreet("123 Any Street");
        address.setCity("My Town");
        customer.setAddress(address);

        PhoneNumber workPhoneNumber = new PhoneNumber();
        workPhoneNumber.setType("work");
        workPhoneNumber.setValue("613-555-1111");
        customer.getPhoneNumbers().add(workPhoneNumber);

        PhoneNumber cellPhoneNumber = new PhoneNumber();
        cellPhoneNumber.setType("cell");
        cellPhoneNumber.setValue("613-555-2222");
        customer.getPhoneNumbers().add(cellPhoneNumber);

        EmbedObject embedObject = new EmbedObject();
        embedObject.setName("test Embed Object");

        List embedObjects = new ArrayList();
        OBFeedEntry obFeedEntry = transformEmbedObject(embedObject);
        embedObjects.add(obFeedEntry);

//        customer.put("otherName", "otherName");
        customer.put("embedObjects", embedObjects);
        // Step 2 - Convert the Domain Model to XML

        Map<String, Source> metadata = new HashMap<String, Source>();
        metadata.put("com.jeff.eclipselink.module", new StreamSource("customer-mapping.xml"));

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("eclipselink-oxm-xml", metadata);

        Class[] classes = new Class[1];
        classes[0] = Customer.class;

        JAXBContext jaxbContext = JAXBContext.newInstance(classes, properties);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(customer, System.out);
    }

    private static OBFeedEntry transformEmbedObject (EmbedObject embedObject) {
        OBFeedEntry obFeedEntry = new OBFeedEntry();
        obFeedEntry.set("name", embedObject.getName());
        return obFeedEntry;
    }
}
