package com.aug.jeff.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "country")
@XmlType(propOrder = { "name", "provinceList" })
public class Country {
    @XmlElement(name = "countryName")
    private String name;

    @XmlElementWrapper(name = "provinces")
    @XmlElement(name = "province")
    private List<Province> provinceList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    @Override
    public String toString() {
        return "Country [name=" + name + ", provinceList=" + provinceList + "]";
    }

}
