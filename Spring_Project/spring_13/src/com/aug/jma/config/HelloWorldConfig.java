package com.aug.jma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aug.jma.domain.HelloWorld;

@Configuration
public class HelloWorldConfig {
    @Bean
    public HelloWorld helloWorld1() {
        return new HelloWorld();
    }
    /**
     * ����Ĵ��뽫��ͬ������� XML ����
     * <beans> <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" />
     * </beans>
     */
}
