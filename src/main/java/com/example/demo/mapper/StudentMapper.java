package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentResponse;
import com.example.demo.entity.School;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public StudentResponse toStudentResponseDto(Student student){
        return
                new StudentResponse(student.getFirstName(),
                        student.getFirstName(),
                        student.getEmail());
    }

    public Student toStudent(StudentDto dto){
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
}
