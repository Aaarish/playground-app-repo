package com.example.PlaygroundApp.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtException extends Exception{
    private List<ErrorModel> errors;

    public JwtException(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
