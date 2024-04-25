package com.example.demo.repository;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //gets the student from the student table based on the firstname provided
    Student findStudentByFirstName(String firstname);
}