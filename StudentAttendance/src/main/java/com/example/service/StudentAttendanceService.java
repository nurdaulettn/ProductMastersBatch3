package com.example.service;

import com.example.model.dto.StudentAttendanceDto;

import java.util.List;

public interface StudentAttendanceService {
    StudentAttendanceDto getStudentAttendanceById(Integer id);
    List<StudentAttendanceDto> getAllStudentAttendance();
    StudentAttendanceDto createStudentAttendance(StudentAttendanceDto dto);

}
