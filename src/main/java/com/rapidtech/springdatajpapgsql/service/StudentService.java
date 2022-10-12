package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.StudentResDto;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
}
