package com.config.testjpa.entity.dto.request;

import com.config.testjpa.entity.Classroom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentRequest {

    private String studentName;
    private Integer age;
    private UUID classroomId;
}
