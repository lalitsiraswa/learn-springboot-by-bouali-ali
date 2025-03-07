package com.learn.spring_boot;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
