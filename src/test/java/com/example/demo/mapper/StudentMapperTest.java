package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentResponse;
import com.example.demo.entity.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp(){
        studentMapper = new StudentMapper();
    }

    @Test
    void toStudentResponseDto() {
        Student student = new Student(
                "Sandip",
                "Gyawali",
                "sandip@gmail.com",
                24
        );

        StudentResponse studentResponse = studentMapper.toStudentResponseDto(student);

        System.out.println(studentResponse);
        assertEquals(studentResponse.firstname(), student.getFirstName());
        assertEquals(studentResponse.lastname(), student.getLastName());
        assertEquals(studentResponse.email(), student.getEmail());
    }

    @Test
    @DisplayName("throws null pointer error when student dto is null")
    void toStudentResponseDtoNull(){
        var msg = assertThrows(NullPointerException.class, ()-> studentMapper.toStudent(null));
        assertEquals(msg.getMessage(), "The studentDto should not be null");
    }

    @Test
    void toStudent() {
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "john@gmail.com",
                22,
                1
        );

        //convert the student dto to Student object
        Student student = studentMapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertEquals(dto.schoolId(), student.getSchool().getId());
        assertEquals(dto.age(), student.getAge());
    }
}