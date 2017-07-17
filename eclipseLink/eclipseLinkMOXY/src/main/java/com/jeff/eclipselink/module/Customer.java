package com.jeff.eclipselink.module;

import org.eclipse.persistence.oxm.annotations.XmlVirtualAccessMethods;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jeff.Ma on 7/13/2017.
 */
public class Customer extends ExtensibleBase{
    private String name;
    private Address address;
    private List<PhoneNumber> phoneNumbers;


    public Customer () {
        phoneNumbers = new ArrayList<PhoneNumber>();
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Address getAddress () {
        return address;
    }

    public void setAddress (Address address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumbers () {
        return phoneNumbers;
    }

    public void setPhoneNumbers (List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}
