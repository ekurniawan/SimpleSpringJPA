package com.rapidtech.springdatajpapgsql.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<Student> students;

    public Course() {
    }

    public Course(String title, int modules, double fee) {
        this.title = title;
        this.modules = modules;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
