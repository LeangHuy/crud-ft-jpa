package com.config.testjpa.service.serviceImpl;

import com.config.testjpa.entity.Classroom;
import com.config.testjpa.entity.Student;
import com.config.testjpa.entity.dto.request.StudentRequest;
import com.config.testjpa.exception.NotFoundException;
import com.config.testjpa.repository.StudentRepository;
import com.config.testjpa.service.ClassService;
import com.config.testjpa.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ClassService classService;

    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Optional<Classroom> classroom = classService.getClassroomById(studentRequest.getClassroomId());
        if (classroom.isEmpty()){
            throw new NotFoundException("Classroom not found");
        }
        Student student = Student.builder()
                .studentName(studentRequest.getStudentName())
                .age(studentRequest.getAge())
                .build();
        student.setClassroom(classroom.get());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(UUID id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            throw new NotFoundException("Student not found");
        }
        return student;
    }

    @Override
    public Student updateStudent(UUID id, StudentRequest studentRequest) {
//        Optional<Student> student = getStudentById(id);
//        student.get().setStudentName(studentRequest.getStudentName());
//        student.get().setAge(studentRequest.getAge());
        Optional<Classroom> classroom = classService.getClassroomById(studentRequest.getClassroomId());
        if (classroom.isEmpty()){
            throw new NotFoundException("Classroom not found");
        }
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Student not found")
        );
        student.setStudentName(studentRequest.getStudentName());
        student.setAge(studentRequest.getAge());
        student.setClassroom(classroom.get());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(UUID id) {
        getStudentById(id);
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByClassName(UUID classId) {
        return studentRepository.findAllByClassroom_Id(classId);
    }
}
