package com.config.testjpa.entity;

import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "classes")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id",unique = true, nullable = false)
    private Integer id;
    @Column(name = "class_name",unique = true,nullable = false)
    private String className;

}
