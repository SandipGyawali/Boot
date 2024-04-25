package com.example.demo.dto;

public record StudentDto (
        String firstName,
        String lastName,
        String email,
        Integer age,
        Integer schoolId
){}
