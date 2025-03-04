package com.learn.spring_boot;

import org.springframework.web.bind.annotation.*;

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

    // http://localhost:8080/hello/lalitsiraswa/lalitsiraswa@gmail.com
    @GetMapping("/hello/{user-name}/{email}")
    public String pathVariable(@PathVariable("user-name") String userName, @PathVariable String email) {
        return "Path-Variable Values => UserName : " + userName + ", Email : " + email;
    }
}
