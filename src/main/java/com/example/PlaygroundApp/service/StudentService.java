package com.example.PlaygroundApp.service;

import com.example.PlaygroundApp.dto.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> getStudents();

    StudentModel getStudent(Long studentId);
    String addStudent(StudentModel studentModel);

    String deleteStudent(Long studentId);
}
