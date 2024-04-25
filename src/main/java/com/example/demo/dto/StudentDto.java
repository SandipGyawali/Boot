package com.example.demo.dto;

import jakarta.validation.constraints.*;

public record StudentDto (
        @NotEmpty(message = "FirstName should not be empty")
        String firstName,
        @NotEmpty(message = "LastName should not be empty")
        String lastName,
        @NotNull
        String email,
        Integer age,
        Integer schoolId
){}
