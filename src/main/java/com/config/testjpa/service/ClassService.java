package com.config.testjpa.service;

import com.config.testjpa.entity.Classroom;
import com.config.testjpa.entity.dto.request.ClassRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClassService {
    Classroom createClassroom(ClassRequest classRequest);
    Optional<Classroom> getClassroomById(UUID id);
    List<Classroom> getAllClassrooms();
    Classroom updateClassroom(UUID id, ClassRequest classRequest);
    void deleteClassroom(UUID id);
}
