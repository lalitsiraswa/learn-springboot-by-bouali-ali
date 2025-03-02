package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    private final MyFirstComponent firstComponent;

    @Autowired
    public MyFirstService(MyFirstComponent firstComponent) {
        this.firstComponent = firstComponent;
    }

    public String tellAStory() {
        return "The dependency is saying : " + firstComponent.sayHello();
    }
}
