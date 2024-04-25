package com.example.demo.controllers;

import com.example.demo.dto.SchoolDto;
import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolController(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/insert")
    public SchoolDto create(@RequestBody SchoolDto schoolDto){
        var school = toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    private School toSchool(SchoolDto dto){
        return new School(dto.name());
    }

    private SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }

    @GetMapping
    public List<SchoolDto> getAllSchools(){
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }
}
