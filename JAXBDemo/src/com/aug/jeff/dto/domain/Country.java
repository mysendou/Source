package com.aug.jeff.dto.domain;

import java.util.List;

public class Country {
    private String name;
    private List<Province> provinces;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    @Override
    public String toString() {
        return "Country [name=" + name + ", provinceList=" + provinces + "]";
    }

}
