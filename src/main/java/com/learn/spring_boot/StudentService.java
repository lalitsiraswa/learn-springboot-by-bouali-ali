package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    @Autowired // Optional -> Constructor Injection
    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public Student findStudentById(Integer studentId) {
        return repository.findById(studentId).orElse(new Student());
    }

    public List<Student> findStudentByName(String name) {
        return repository.findAllByFirstnameContaining(name);
    }

    public void deleteStudentById(Integer studentId) {
        repository.deleteById(studentId);
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }
}
