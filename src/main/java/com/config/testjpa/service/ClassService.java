package com.config.testjpa.service;

import com.config.testjpa.entity.Classroom;
import com.config.testjpa.entity.dto.request.ClassRequest;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    Classroom createClassroom(ClassRequest classRequest);
    Optional<Classroom> getClassroomById(Integer id);
    List<Classroom> getAllClassrooms();
}
