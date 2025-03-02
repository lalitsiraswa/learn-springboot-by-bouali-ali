package com.learn.spring_boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public MyFirstComponent myFirstComponent() {
        return new MyFirstComponent("First Bean");
    }
}
