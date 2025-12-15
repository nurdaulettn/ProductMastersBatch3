package com.example.service;

import com.example.model.AttendanceMapper;
import com.example.model.AttendanceNotFound;
import com.example.model.dto.StudentAttendanceDto;
import com.example.model.entity.StudentAttendance;
import com.example.repository.StudentAttendanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentAttendanceServiceImpl implements StudentAttendanceService {
    private final StudentAttendanceRepository studentAttendanceRepository;
    private final AttendanceMapper mapper;


    @Override
    public StudentAttendanceDto getStudentAttendanceById(Integer id) {
        StudentAttendance studentAttendance = studentAttendanceRepository.findById(id)
                .orElseThrow(() -> new AttendanceNotFound("Attendance not found"));
        return mapper.toStudentAttendanceDto(studentAttendance);
    }

    @Override
    public List<StudentAttendanceDto> getAllStudentAttendance() {

        return studentAttendanceRepository.findAll().stream()
                .map(mapper::toStudentAttendanceDto)
                .toList();
    }

    @Override
    public StudentAttendanceDto createStudentAttendance(StudentAttendanceDto dto) {
        StudentAttendance studentAttendance = StudentAttendance.builder()
                .name(dto.getName())
                .groupName(dto.getGroupName())
                .attended(dto.getAttended())
                .build();
        StudentAttendance saved = studentAttendanceRepository.save(studentAttendance);
        return mapper.toStudentAttendanceDto(saved);
    }
}
