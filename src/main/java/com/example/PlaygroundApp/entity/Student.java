package com.example.PlaygroundApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private int marks;
    private String city;
    private String studentEmail;
    private String role;
    private String studentPassword;
}
