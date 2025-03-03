package com.learn.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
//        MyFirstComponent firstComponent = applicationContext.getBean(MyFirstComponent.class);
        MyFirstComponent firstComponent = applicationContext.getBean("myFirstComponent", MyFirstComponent.class);
        System.out.println(firstComponent.sayHello());

        MyFirstService myFirstService = applicationContext.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
        System.out.println("Get JAVA Version : " + myFirstService.getJavaVersion());
        System.out.println("Get Operating System Name : " + myFirstService.getOperatingSystemName());
        System.out.println("Custom Properties : " + myFirstService.readProp());
    }
}
