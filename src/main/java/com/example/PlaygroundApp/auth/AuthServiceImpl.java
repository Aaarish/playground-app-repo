package com.example.PlaygroundApp.auth;

import com.example.PlaygroundApp.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse authenticateAdmin(AuthRequest authRequest) {
        UserDetails adminDetails = userDetailsService.loadUserByUsername(authRequest.getAdminUsername());

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequest.getAdminUsername(), authRequest.getAdminPassword());
        Authentication authenticated = authenticationManager.authenticate(authToken);

        if(authenticated == null){
            return null;
        }

        String jwt = jwtUtil.generateToken(adminDetails);
        return AuthResponse.builder()
                .jwt(jwt)
                .build();
    }
}
