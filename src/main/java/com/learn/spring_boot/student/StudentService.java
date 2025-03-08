package com.learn.spring_boot.student;

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
        return this.studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents() {
        return this.repository.findAll()
                .stream()
                .map(this.studentMapper::toStudentResponseDto)
                .toList();
    }

    public StudentResponseDto findStudentById(Integer studentId) {
        return this.repository.findById(studentId)
                .map(this.studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentByName(String name) {
        return this.repository.findAllByFirstnameContaining(name)
                .stream()
                .map(this.studentMapper::toStudentResponseDto)
                .toList();
    }

    public void deleteStudentById(Integer studentId) {
        this.repository.deleteById(studentId);
    }

    public StudentResponseDto updateStudent(Student student) {
        return this.studentMapper.toStudentResponseDto(repository.save(student));
    }
}
