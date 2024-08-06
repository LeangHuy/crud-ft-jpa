package com.config.testjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "classes")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "class_id",unique = true, nullable = false)
    private UUID id;
    @Column(name = "class_name",unique = true,nullable = false)
    private String className;

}
