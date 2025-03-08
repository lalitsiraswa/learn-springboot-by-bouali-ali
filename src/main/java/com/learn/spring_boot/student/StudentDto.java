package com.learn.spring_boot.student;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
