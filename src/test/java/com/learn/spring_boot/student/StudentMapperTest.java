package com.learn.spring_boot.student;

import org.junit.jupiter.api.*;

class StudentMapperTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside @BeforeAll Method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside @AfterAll Method!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Inside @BeforeEach Method!");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside @AfterEach Method!");
    }

    @Test
    public void testToStudent() {
        System.out.println("Testing toStudent() Method!");
    }

    @Test
    public void testToStudentResponseDto() {
        System.out.println("Testing testToStudentResponseDto() Method!");
    }
}