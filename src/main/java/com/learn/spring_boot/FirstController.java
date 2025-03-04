package com.learn.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! From My First Controller.";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request Accepted! and message is : " + message;
    }

    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order) {
        return "Request Accepted! and order is : " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postOrderRecord(@RequestBody OrderRecord orderRecord) {
        return "Request Accepted! and order is : " + orderRecord.toString();
    }
}
