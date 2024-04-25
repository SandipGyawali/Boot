package com.example.demo.controllers;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentResponse;
import com.example.demo.entity.School;
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
    public StudentResponse post(@RequestBody StudentDto studentDto){
        System.out.println(studentDto);
        var student = toStudent(studentDto);
        return toStudentResponseDto(studentRepository.save(student));
    }

    private StudentResponse toStudentResponseDto(Student student){
        return
                new StudentResponse(student.getFirstName(),
                student.getFirstName(),
                student.getEmail());
    }

    private Student toStudent(StudentDto dto){
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setAge(dto.age());
        student.setEmail(dto.email());

        School school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
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
