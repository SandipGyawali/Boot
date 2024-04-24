package com.example.demo.controllers;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        //gets all the data from the student table.
        return studentRepository.findAll();
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Student post(@RequestBody Student student){
        return studentRepository.save(student);
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
}
