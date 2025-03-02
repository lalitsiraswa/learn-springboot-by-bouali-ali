package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    @Autowired
    @Qualifier("bean1")
    private MyFirstComponent firstComponent;

    public String tellAStory() {
        return "The dependency is saying : " + firstComponent.sayHello();
    }
}
