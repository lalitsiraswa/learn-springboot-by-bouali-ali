package com.learn.spring_boot.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    //    Which service we want to test.
    @InjectMocks
    private StudentService studentService;

    //    Declare the dependencies.
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
//        Given
        StudentDto studentDto = new StudentDto("Lalit", "Siraswa", "lalitsiraswa@gmail.com", 152);
        Student student = new Student("Lalit", "Siraswa", "lalitsiraswa@gmail.com", 25);
        Student savedStudent = new Student("Lalit", "Siraswa", "lalitsiraswa@gmail.com", 25);
        savedStudent.setId(201);
//        Mock the calls
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto("Lalit", "Siraswa", "lalitsiraswa@gmail.com"));
//        When
        StudentResponseDto studentResponseDto = studentService.saveStudent(studentDto);
//        Then
        assertNotNull(studentResponseDto);
        assertEquals(studentDto.firstname(), studentResponseDto.firstname());
        assertEquals(studentDto.lastname(), studentResponseDto.lastname());
        assertEquals(studentDto.email(), studentResponseDto.email());

//        Adding Verification on Calling all the functions(studentMapper.toStudent, studentRepository.save, studentMapper.toStudentResponseDto) only once, So it will not create duplicate entries in the database.
        verify(studentMapper, times(1)).toStudent(studentDto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(savedStudent);
    }
}