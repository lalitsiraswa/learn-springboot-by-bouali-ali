package com.learn.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        MyFirstComponent firstComponent = applicationContext.getBean(MyFirstComponent.class);
        System.out.println(firstComponent.sayHello());
    }

    //    @Bean
    public MyFirstComponent myFirstComponent() {
        return new MyFirstComponent();
    }
}
