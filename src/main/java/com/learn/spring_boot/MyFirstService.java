package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:custom.properties")
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {
    private final MyFirstComponent firstComponent;
    @Value("${my.custom.property.2}")
    private String customProperty;
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("${my.prop.2}")
    private String customPropertyFromAnotherFile2;
    @Value("${my.custom.property.int}")
    private Integer customPropertyInt;

    public MyFirstService(@Qualifier("bean1") MyFirstComponent firstComponent) {
        this.firstComponent = firstComponent;
    }

    public String tellAStory() {
        return "The dependency is saying : " + firstComponent.sayHello();
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

}
