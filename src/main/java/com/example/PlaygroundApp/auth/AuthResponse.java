package com.example.PlaygroundApp.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponse {
    private String jwt;
}
