package com.config.testjpa.service;

import com.config.testjpa.entity.Student;
import com.config.testjpa.entity.dto.request.StudentRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService  {

    Student createStudent(StudentRequest studentRequest);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(UUID id);
    Student updateStudent(UUID id, StudentRequest studentRequest);
    void deleteStudent(UUID id);
}
