package com.learn.spring_boot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
//@Service
//@Repository
public class MyFirstComponent {
    public String sayHello() {
        return "Hello from the MyFirstComponent!";
    }
}
