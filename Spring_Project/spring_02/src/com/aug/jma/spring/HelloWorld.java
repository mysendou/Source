package com.aug.jma.spring;

public class HelloWorld {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }

    public void init() {
        System.out.println("Execute init method");
    }

    public void destroy() {
        System.out.println("Execute Destory Method");
    }
}
