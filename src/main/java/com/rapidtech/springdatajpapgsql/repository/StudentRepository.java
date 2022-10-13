package com.rapidtech.springdatajpapgsql.repository;

import com.rapidtech.springdatajpapgsql.model.Course;
import com.rapidtech.springdatajpapgsql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
