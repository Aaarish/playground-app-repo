package com.example.PlaygroundApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorModel {
    private ErrorType errorCode;
    private String errorMessage;
}
