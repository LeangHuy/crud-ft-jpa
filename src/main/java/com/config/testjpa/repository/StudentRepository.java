package com.config.testjpa.repository;

import com.config.testjpa.entity.Student;
import com.config.testjpa.entity.dto.request.StudentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findAllByClassroom_Id(UUID classId);

}
