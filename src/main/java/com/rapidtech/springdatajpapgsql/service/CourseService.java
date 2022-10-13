package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.CourseReqDto;
import com.rapidtech.springdatajpapgsql.dto.CourseResDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentDto;

import java.util.List;

public interface CourseService {
    List<CourseResDto> getAllCourse();
    CourseResDto insertStudent(CourseReqDto courseReqDto);
    void registerStudentToCourse(CourseWithStudentDto courseWithStudentDto);
}
