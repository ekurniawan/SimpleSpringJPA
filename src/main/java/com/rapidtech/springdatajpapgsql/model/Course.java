package com.rapidtech.springdatajpapgsql.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();
}
