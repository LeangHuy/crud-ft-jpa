package com.config.testjpa.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id",nullable = false,unique = true)
    private UUID id;
    @Column(name = "student_name",nullable = false,length = 50)
    private String studentName;
    @Column(name = "age",nullable = false)
    private Integer age;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Classroom classroom;

}
