package com.config.testjpa.controller;

import com.config.testjpa.entity.Student;
import com.config.testjpa.entity.dto.request.StudentRequest;
import com.config.testjpa.service.StudentService;
import com.config.testjpa.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @Operation(summary = "Create new student.")
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentRequest studentRequest) {
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Create new student successful.")
                .payload(studentService.createStudent(studentRequest))
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all student.")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("Get all students successful.")
                .payload(studentService.getAllStudents())
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{studentId}")
    @Operation(summary = "Get student by id.")
    public ResponseEntity<ApiResponse<Optional<Student>>> getStudentById(@PathVariable UUID studentId) {
        ApiResponse<Optional<Student>> response = ApiResponse.<Optional<Student>>builder()
                .message("Get student by id successfully.")
                .payload(studentService.getStudentById(studentId))
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{studentId}")
    @Operation(summary = "Update student by id.")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable UUID studentId, @RequestBody StudentRequest studentRequest) {
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Update student successfully.")
                .payload(studentService.updateStudent(studentId, studentRequest))
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{studentId}")
    @Operation(summary = "Delete student by id.")
    public ResponseEntity<ApiResponse<Student>> deleteStudent(@PathVariable UUID studentId) {
        studentService.deleteStudent(studentId);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Delete student successfully.")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/classrooms/{classId}")
    @Operation(summary = "Get student by className.")
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsByClassName(@PathVariable UUID classId) {
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("Get student by class successfully.")
                .payload(studentService.getStudentsByClassName(classId))
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
