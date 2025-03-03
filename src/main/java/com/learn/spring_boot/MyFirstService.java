package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    private MyFirstComponent firstComponent;

    @Autowired
    public void setMyFirstComponent(@Qualifier("bean1") MyFirstComponent myFirstComponent) {
        this.firstComponent = myFirstComponent;
    }

    public String tellAStory() {
        return "The dependency is saying : " + firstComponent.sayHello();
    }
}
