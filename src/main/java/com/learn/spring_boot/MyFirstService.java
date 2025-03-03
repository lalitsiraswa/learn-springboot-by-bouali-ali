package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    private MyFirstComponent firstComponent;
    private Environment environment;

    @Autowired
    public void setMyFirstComponent(@Qualifier("bean1") MyFirstComponent myFirstComponent) {
        this.firstComponent = myFirstComponent;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String tellAStory() {
        return "The dependency is saying : " + firstComponent.sayHello();
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOperatingSystemName() {
        return environment.getProperty("os.name");
    }

    public String readProp() {
        return environment.getProperty("my.custom.property") + ", ProjectName : " + environment.getProperty("spring.application.name");
    }
}
