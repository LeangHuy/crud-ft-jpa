package com.config.testjpa.service.serviceImpl;

import com.config.testjpa.entity.Classroom;
import com.config.testjpa.entity.dto.request.ClassRequest;
import com.config.testjpa.exception.NotFoundException;
import com.config.testjpa.repository.ClassRepository;
import com.config.testjpa.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    @Override
    public Classroom createClassroom(ClassRequest classRequest) {
        Classroom classroom = Classroom.builder()
                .className(classRequest.getClassName())
                .build();
        return classRepository.save(classroom);
    }

    @Override
    public Optional<Classroom> getClassroomById(UUID id) {
        classRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Classroom not found")
        );
        return classRepository.findById(id);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classRepository.findAll();
    }

    @Override
    public Classroom updateClassroom(UUID id,ClassRequest classRequest) {
//        getClassroomById(id);
        Classroom classroom = classRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Classroom not found")
        );
        classroom.setClassName(classRequest.getClassName());
        return classRepository.save(classroom);
    }

    @Override
    public void deleteClassroom(UUID id) {
        getClassroomById(id);
        classRepository.deleteById(id);
    }
}
