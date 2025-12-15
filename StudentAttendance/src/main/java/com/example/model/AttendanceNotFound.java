package com.example.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AttendanceNotFound extends RuntimeException {
    public AttendanceNotFound(String message) {
        super(message);
    }
}
