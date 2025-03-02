package com.learn.spring_boot;

import org.springframework.stereotype.Component;

@Component
public class MyFirstComponent {
    public String sayHello() {
        return "Hello from the MyFirstComponent!";
    }
}
