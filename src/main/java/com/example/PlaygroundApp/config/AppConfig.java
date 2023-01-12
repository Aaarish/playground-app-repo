package com.example.PlaygroundApp.config;

import com.example.PlaygroundApp.auth.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private static final List<Admin> ADMINS = Arrays.asList(
            new Admin("Aarish", "{noop}123", "ADMIN", true, true, true, true)
    );

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return (username) -> ADMINS.stream()
                .filter(admin -> admin.getAdminUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Admin credentials are wrong"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
