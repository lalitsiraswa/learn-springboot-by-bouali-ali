package com.learn.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! From My First Controller.";
    }

    @PostMapping("/post")
    public String post(String message) {
        return "Request Accepted! and message is : " + message;
    }
}
