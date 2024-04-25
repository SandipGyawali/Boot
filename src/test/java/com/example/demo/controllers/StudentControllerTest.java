package com.example.demo.controllers;

import com.example.demo.dto.*;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllStudents() {
        System.out.println("hello");
    }

    @Test
    @DisplayName("should successfully save the student")
    void post() {
        //given
        StudentDto dto = new StudentDto(
                "sandip",
                "gyawali",
                "sandip@gmail.com",
                12,
                1
        );

        Student student = new Student(
                "sandip",
                "gyawali",
                "sandip@gmail.com",
                20
        );

        when(studentMapper.toStudent(dto)).thenReturn(student);
        // Mock the save method to return the given student
        when(studentRepository.save(student)).thenReturn(student);

        when(studentMapper.toStudentResponseDto(student)).
                thenReturn(
                        new StudentResponse(
                                "sandip",
                                "gyawali",
                                "sandip@gmail.com"
                        )
                );

        StudentResponse response = studentController.post(dto);
        assertEquals(response.firstname(), dto.firstName());
        assertEquals(response.lastname(), dto.lastName());
        assertEquals(response.email(), dto.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentMapper, times(1)).toStudentResponseDto(student);
    }
}