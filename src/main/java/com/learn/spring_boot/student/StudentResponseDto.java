package com.learn.spring_boot.student;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email
) {
}
