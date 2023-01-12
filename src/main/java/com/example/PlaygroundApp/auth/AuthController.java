package com.example.PlaygroundApp.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> adminLogin(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.authenticateAdmin(authRequest));
    }
}
