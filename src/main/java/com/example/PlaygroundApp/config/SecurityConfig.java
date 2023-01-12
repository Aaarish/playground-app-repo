package com.example.PlaygroundApp.config;

import com.example.PlaygroundApp.jwt.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/admins/**").permitAll()
//                .requestMatchers(POST, "/api/v1/students/**").hasRole("ADMIN")
//                .requestMatchers(DELETE, "/api/v1/students/**").hasRole("ADMIN")
//                .requestMatchers(GET, "/api/v1/students/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();

        return http.build();
    }
}
