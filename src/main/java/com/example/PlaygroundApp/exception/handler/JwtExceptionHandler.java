package com.example.PlaygroundApp.exception.handler;

import com.example.PlaygroundApp.exception.ErrorModel;
import com.example.PlaygroundApp.exception.JwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class JwtExceptionHandler {

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<List<ErrorModel>> handleJwtException(JwtException e){
        return ResponseEntity.badRequest().body(e.getErrors());
    }
}
