package com.example.demo.controllers;

import com.example.demo.dto.*;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        //gets all the data from the student table.
        return studentRepository.findAll();
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse post(@Valid @RequestBody StudentDto studentDto){
        var student = studentMapper.toStudent(studentDto);
        return studentMapper.toStudentResponseDto(studentRepository.save(student));
    }

    @GetMapping("/{firstname}")
    public Student getStudentByFirstname(@PathVariable String firstname){
        return studentRepository.findStudentByFirstName(firstname);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable Integer id){
        System.out.println(id);
        studentRepository.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}