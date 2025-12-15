package com.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceDto {
    private int id;
    private String name;
    private String groupName;
    private Boolean attended;
}
