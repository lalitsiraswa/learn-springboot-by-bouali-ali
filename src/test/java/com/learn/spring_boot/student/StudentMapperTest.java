package com.learn.spring_boot.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {
    @AfterEach
    void tearDown() {
        System.out.println("Inside @AfterEach Method!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Inside @BeforeEach Method!");
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