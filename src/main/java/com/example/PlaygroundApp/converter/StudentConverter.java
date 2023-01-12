package com.example.PlaygroundApp.converter;

import com.example.PlaygroundApp.dto.StudentModel;
import com.example.PlaygroundApp.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentConverter {
    private final PasswordEncoder passwordEncoder;

    public StudentModel convertEntityToModel(Student student){
        StudentModel studentModel = new StudentModel();

        studentModel.setStudentName(student.getStudentName());
        studentModel.setCity(student.getCity());
        studentModel.setMarks(student.getMarks());
        studentModel.setStudentEmail(student.getStudentEmail());
        studentModel.setStudentPassword(student.getStudentPassword());

        return studentModel;
    }

    public Student convertModelToEntity(StudentModel studentModel){
        Student student = new Student();

        student.setStudentName(studentModel.getStudentName());
        student.setCity(studentModel.getCity());
        student.setMarks(studentModel.getMarks());
        student.setStudentEmail(studentModel.getStudentEmail());
        student.setStudentPassword(passwordEncoder.encode(studentModel.getStudentPassword()));
        student.setRole("USER");

        return student;
    }
}
