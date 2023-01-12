package com.example.PlaygroundApp.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminUsername(String username);
}
