package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FirstController {
    private final StudentRepository repository;

    @Autowired // Optional -> Constructor Injection
    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer studentId) {
        return repository.findById(studentId).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String name) {
        return repository.findAllByFirstnameContaining(name);
    }

    //    ----------------------------------------------------------------------------------------------------
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! From My First Controller.";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request Accepted! and message is : " + message;
    }

    //     http://localhost:8080/hello/lalitsiraswa/lalitsiraswa@gmail.com
    @GetMapping("/path-variable/{user-name}/{email}")
    public String pathVariable(@PathVariable("user-name") String userName, @PathVariable String email) {
        return "Path-Variable Values => UserName : " + userName + ", Email : " + email;
    }

    //    http://localhost:8080/request-param?user-name=lalitsiraswa&email=lalitsiraswa@gmail.com
    //    @RequestParam: this annotation is used to extract Query Parameters from the URL.
    @GetMapping("/request-param")
    public String requestParam(@RequestParam("user-name") String userName, @RequestParam String email) {
        return "Request-Param Values => UserName : " + userName + ", Email : " + email;
    }
}
