package com.learn.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    @Autowired // Optional
    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto schoolDto) {
        var school = toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    private School toSchool(SchoolDto schoolDto) {
        var school = new School();
        school.setName(schoolDto.name());
        return school;
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .toList();
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
