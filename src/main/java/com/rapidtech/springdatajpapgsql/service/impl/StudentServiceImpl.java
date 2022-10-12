package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.StudentResDto;
import com.rapidtech.springdatajpapgsql.model.Student;
import com.rapidtech.springdatajpapgsql.repository.StudentRepository;
import com.rapidtech.springdatajpapgsql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for(Student student : students){
            studentResDtoList.add(StudentResDto.builder()
            .id(student.getId()).name(student.getName()).age(student.getAge()).build());
        }
        return studentResDtoList;
    }
}
