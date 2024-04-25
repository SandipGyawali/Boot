package com.example.demo.controllers;

import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolController(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/insert")
    public School create(@RequestBody School school){
        System.out.println(school);
        return schoolRepository.save(school);
    }

    @GetMapping
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }
}
