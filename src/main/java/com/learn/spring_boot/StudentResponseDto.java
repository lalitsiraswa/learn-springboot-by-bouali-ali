package com.learn.spring_boot;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email
) {
}
