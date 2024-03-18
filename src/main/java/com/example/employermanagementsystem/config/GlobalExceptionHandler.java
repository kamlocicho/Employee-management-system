package com.example.employermanagementsystem.config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleException(CustomException e) {
        return ResponseEntity.status(e.getStatus()).body(e);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<?> handleException(ExpiredJwtException e) {
        return ResponseEntity.status(401).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
