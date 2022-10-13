package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.StudentReqDto;
import com.rapidtech.springdatajpapgsql.dto.StudentResDto;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
    StudentResDto getStudentById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    StudentResDto updateStudent(Long id, StudentReqDto studentReqDto);
    void deleteStudent(Long id);
}
