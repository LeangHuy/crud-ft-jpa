package com.config.testjpa.controller;

import com.config.testjpa.entity.Classroom;
import com.config.testjpa.entity.dto.request.ClassRequest;
import com.config.testjpa.service.ClassService;
import com.config.testjpa.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/classrooms")
@AllArgsConstructor
public class ClassController {

    private final ClassService classService;

    @PostMapping
    @Operation(summary = "create classroom.")
    public ResponseEntity<ApiResponse<Classroom>> createClassroom(@RequestBody ClassRequest classRequest) {
        ApiResponse<Classroom> response = ApiResponse.<Classroom>builder()
                .message("Create classroom successfully")
                .payload(classService.createClassroom(classRequest))
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{classroomId}")
    @Operation(summary = "Get classroom by id.")
    public ResponseEntity<ApiResponse<Optional<Classroom>>> getClassroomById(@PathVariable UUID classroomId) {
        ApiResponse<Optional<Classroom>> response = ApiResponse.<Optional<Classroom>>builder()
                .message("Get classroom by id successfully")
                .payload(classService.getClassroomById(classroomId))
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all classroom.")
    public ResponseEntity<ApiResponse<List<Classroom>>> getAllClassroom() {
        ApiResponse<List<Classroom>> response = ApiResponse.<List<Classroom>>builder()
                .message("Get classroom by id successfully")
                .payload(classService.getAllClassrooms())
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{classroomId}")
    @Operation(summary = "Update classroom by id.")
    public ResponseEntity<ApiResponse<Classroom>> updateClassroomById(@PathVariable UUID classroomId,@RequestBody ClassRequest classRequest) {
        ApiResponse<Classroom> response = ApiResponse.<Classroom>builder()
                .message("Update classroom by id successfully")
                .payload(classService.updateClassroom(classroomId, classRequest))
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
