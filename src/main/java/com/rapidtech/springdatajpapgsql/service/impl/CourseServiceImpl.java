package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.CourseReqDto;
import com.rapidtech.springdatajpapgsql.dto.CourseResDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentDto;
import com.rapidtech.springdatajpapgsql.model.Course;
import com.rapidtech.springdatajpapgsql.model.Student;
import com.rapidtech.springdatajpapgsql.repository.CourseRepository;
import com.rapidtech.springdatajpapgsql.repository.StudentRepository;
import com.rapidtech.springdatajpapgsql.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<CourseResDto> getAllCourse() {
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        List<Course> courseList = courseRepository.findAll();
        for(Course course : courseList){
            courseResDtoList.add(CourseResDto.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .modules(course.getModules())
                    .fee(course.getFee())
                    .build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseResDto insertStudent(CourseReqDto courseReqDto) {
        Course newCourse = Course.builder()
                .title(courseReqDto.getTitle())
                .modules(courseReqDto.getModules())
                .fee(courseReqDto.getFee())
                .build();
        Course result = courseRepository.save(newCourse);
        return CourseResDto.builder()
                .id(result.getId())
                .title(result.getTitle())
                .modules(result.getModules())
                .fee(result.getFee())
                .build();
    }

    @Override
    public void registerStudentToCourse(CourseWithStudentDto courseWithStudentDto) {
        Course course = courseRepository.findById(courseWithStudentDto.getCourseId()).get();
        Student student = studentRepository.findById(courseWithStudentDto.getStudentId()).get();

        student.getCourses().add(course);
        studentRepository.save(student);
    }
}
