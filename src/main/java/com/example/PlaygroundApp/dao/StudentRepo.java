package com.example.PlaygroundApp.dao;

import com.example.PlaygroundApp.dto.StudentModel;
import com.example.PlaygroundApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByStudentId(Long studentId);
}
