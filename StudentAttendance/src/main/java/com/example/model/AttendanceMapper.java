package com.example.model;

import com.example.model.dto.StudentAttendanceDto;
import com.example.model.entity.StudentAttendance;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {
    public StudentAttendanceDto toStudentAttendanceDto(StudentAttendance studentAttendance) {
        return StudentAttendanceDto.builder()
                .id(studentAttendance.getId())
                .name(studentAttendance.getName())
                .groupName(studentAttendance.getGroupName())
                .attended(studentAttendance.getAttended())
                .build();
    }
}
