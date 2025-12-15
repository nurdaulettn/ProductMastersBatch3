package com.example.controller;

import com.example.model.dto.StudentAttendanceDto;
import com.example.model.entity.StudentAttendance;
import com.example.service.StudentAttendanceService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class StudentAttendanceController {
    private final StudentAttendanceService service;

    @GetMapping()
    public String index(Model model, HttpSession session) {
        StudentAttendanceDto dto = new StudentAttendanceDto();
        List<StudentAttendanceDto> attendances = service.getAllStudentAttendance();
        boolean isTeacher = false;
        if(!Objects.isNull(session) && "teacher".equals(session.getAttribute("role"))) {
            isTeacher = true;
        }
        model.addAttribute("dto", dto);
        model.addAttribute("attendances", attendances);
        model.addAttribute("isTeacher", isTeacher);
        return "attendance";
    }

    @PostMapping
    public String save(StudentAttendanceDto dto){
        service.createStudentAttendance(dto);
        return "redirect:/attendance";
    }

}
