package com.learn.spring_boot.student;

import com.learn.spring_boot.school.School;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {
        if (Objects.isNull(dto)) {
            throw new NullPointerException("The Student Dto should not be null!");
        }
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail());
    }
}
