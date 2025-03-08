package com.learn.spring_boot.student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired // Optional -> Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto studentDto) {
        return this.studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return this.studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer studentId) {
        return this.studentService.findStudentById(studentId);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentByName(@PathVariable("student-name") String name) {
        return this.studentService.findStudentByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id) {
        this.studentService.deleteStudentById(id);
    }

    @PutMapping("/students")
    public StudentResponseDto update(@RequestBody Student student) {
        return this.studentService.updateStudent(student);
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
