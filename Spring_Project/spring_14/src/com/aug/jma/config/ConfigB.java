package com.aug.jma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.aug.jma.domain.B;

@Configuration
@Import(ConfigA.class)
public class ConfigB {

    @Bean
    public B b(){
        return new B();
    }
}
