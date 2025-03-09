package com.learn.spring_boot.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
//        Given
        StudentDto studentDto = new StudentDto("Lalit", "Siraswa", "lalitsiraswa@gmail.com", 1);
//        When
        Student student = studentMapper.toStudent(studentDto);
//        Then
        assertEquals(studentDto.firstname(), student.getFirstname());
        assertEquals(studentDto.lastname(), student.getLastname());
        assertEquals(studentDto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(studentDto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        Exception exception = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("The Student Dto should not be null!", exception.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
//        Given
        Student student = new Student("Lalit", "Siraswa", "lalitsiraswa@gmail.com", 25);
//        When
        StudentResponseDto studentResponseDto = studentMapper.toStudentResponseDto(student);
//        Then
        assertEquals(student.getFirstname(), studentResponseDto.firstname());
        assertEquals(student.getLastname(), studentResponseDto.lastname());
        assertEquals(student.getEmail(), studentResponseDto.email());
    }
}