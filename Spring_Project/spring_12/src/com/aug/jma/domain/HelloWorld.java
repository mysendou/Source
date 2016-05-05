package com.aug.jma.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {
    private String message;

    public String getMessage() {
        System.out.println("Hello World message : " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init(){
        System.out.println("Hello world init method");
    }
    
    @PreDestroy
    public void destory(){
        System.out.println("Hello world destory method");
    }
}
