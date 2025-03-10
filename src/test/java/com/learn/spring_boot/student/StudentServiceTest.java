package com.learn.spring_boot.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void should_return_all_students() {
//        Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("Lalit", "Siraswa", "lalitsiraswa@gmail.com", 25));
        students.add(new Student("Krishna", "Siraswa", "krishnasiraswa@gmail.com", 30));
        students.add(new Student("Jyoti", "Siraswa", "jyotisiraswa@gmail.com", 28));

        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        studentResponseDtos.add(new StudentResponseDto("Lalit", "Siraswa", "lalitsiraswa@gmail.com"));
        studentResponseDtos.add(new StudentResponseDto("Krishna", "Siraswa", "krishnasiraswa@gmail.com"));
        studentResponseDtos.add(new StudentResponseDto("Jyoti", "Siraswa", "jyotisiraswa@gmail.com"));

//        Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        for (int i = 0; i < students.size(); i++) {
            when(studentMapper.toStudentResponseDto(students.get(i))).thenReturn(studentResponseDtos.get(i));
        }

//        When
        List<StudentResponseDto> studentResponseDtoList = studentService.findAllStudents();
//        Then
        assertEquals(students.size(), studentResponseDtoList.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void should_return_student_by_id() {
//        Given
        Integer studentId = 1;
        Student student = new Student("Lalit", "Siraswa", "lalitsiraswa@gmail.com", 25);
        StudentResponseDto studentResponseDto = new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail());

//        Mock the calls
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(student)).thenReturn(studentResponseDto);

//        When
        StudentResponseDto responseDto = studentService.findStudentById(studentId);
//        Then
        assertEquals(student.getFirstname(), responseDto.firstname());
        assertEquals(student.getLastname(), responseDto.lastname());
        assertEquals(student.getEmail(), responseDto.email());

        verify(studentRepository, times(1)).findById(studentId);
        verify(studentMapper, times(1)).toStudentResponseDto(student);
    }
}