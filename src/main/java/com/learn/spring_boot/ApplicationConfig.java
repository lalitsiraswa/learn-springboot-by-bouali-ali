package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {
    @Bean
    @Qualifier("bean1")
    public MyFirstComponent myFirstComponent() {
        return new MyFirstComponent("First Bean");
    }

    @Bean
    public MyFirstComponent mySecondComponent() {
        return new MyFirstComponent("Second Bean");
    }

    @Bean
//    @Primary
    public MyFirstComponent myThirdComponent() {
        return new MyFirstComponent("Third Bean");
    }
}
