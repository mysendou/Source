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
     * 上面的代码将等同于下面的 XML 配置
     * <beans> <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" />
     * </beans>
     */
}
