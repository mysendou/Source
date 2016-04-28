package com.aug.jeff.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "provCity" })
public class Province {
    @XmlElement
    private String name;
    @XmlElement
    private String provCity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvCity() {
        return provCity;
    }

    public void setProvCity(String provCity) {
        this.provCity = provCity;
    }

    @Override
    public String toString() {
        return "Province [name=" + name + ", provCity=" + provCity + "]";
    }

}
