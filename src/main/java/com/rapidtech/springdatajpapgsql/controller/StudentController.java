package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.dto.StudentResDto;
import com.rapidtech.springdatajpapgsql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResDto> getAllStudent(){
        return studentService.getAllStudent();
    }
}
