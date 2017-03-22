package com.aug.jma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aug.jma.domain.A;

@Configuration
public class ConfigA {
    @Bean
    public A a(){
        return new A();
    }
}
