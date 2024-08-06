package com.config.testjpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id",nullable = false,unique = true)
    private Integer id;
    @Column(name = "student_name",nullable = false,length = 50)
    private String studentName;
    @Column(name = "age",nullable = false)
    private Integer age;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id",nullable = false)
    private Classroom classroom;


}
