package com.aug.jeff.dto.domain;


public class Province {
    private String name;
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
