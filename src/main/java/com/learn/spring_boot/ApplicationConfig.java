package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    @Qualifier("bean1")
    public MyFirstComponent myFirstComponent() {
        return new MyFirstComponent("First Bean");
    }

    @Bean
    @Qualifier("bean2")
    public MyFirstComponent mySecondComponent() {
        return new MyFirstComponent("Second Bean");
    }
}
