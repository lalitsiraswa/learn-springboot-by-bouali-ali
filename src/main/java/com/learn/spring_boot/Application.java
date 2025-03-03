package com.learn.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        var application = new SpringApplication(Application.class);
        application.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));

//        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        ConfigurableApplicationContext applicationContext = application.run(args);
//        MyFirstComponent firstComponent = applicationContext.getBean(MyFirstComponent.class);
        MyFirstComponent firstComponent = applicationContext.getBean("myFirstComponent", MyFirstComponent.class);
        System.out.println(firstComponent.sayHello());

        MyFirstService myFirstService = applicationContext.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
        System.out.println("custom Property From Another File : " + myFirstService.getCustomPropertyFromAnotherFile());
        System.out.println("custom Property From Another File - 2 : " + myFirstService.getCustomPropertyFromAnotherFile2());
        System.out.println("Reading value from application.properties : " + myFirstService.getCustomProperty());
        System.out.println("Reading Integer value from application.properties : " + myFirstService.getCustomPropertyInt());
    }
}
