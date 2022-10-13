package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.dto.CourseReqDto;
import com.rapidtech.springdatajpapgsql.dto.CourseResDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentResDto;
import com.rapidtech.springdatajpapgsql.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResDto> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping
    public CourseResDto insertCourse(@RequestBody CourseReqDto courseReqDto){
        return courseService.insertStudent(courseReqDto);
    }

    @PostMapping("/student")
    public String registerStudentToCourse(@RequestBody CourseWithStudentDto courseWithStudentDto){
        courseService.registerStudentToCourse(courseWithStudentDto);
        return "Berhasil menambahkan student " +courseWithStudentDto.getStudentId().toString()+
                " ke course "+courseWithStudentDto.getCourseId().toString();
    }

    @GetMapping("/{id}")
    public CourseWithStudentResDto getCourseWithStudentById(@PathVariable("id") Long id){
        return courseService.getCourseWithStudentById(id);
    }

    @GetMapping("/withstudents")
    public List<CourseWithStudentResDto> getAllCourseWithStudent(){
        return courseService.getAllCourseWithStudent();
    }
}
