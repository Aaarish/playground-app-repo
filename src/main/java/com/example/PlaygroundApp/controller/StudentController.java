package com.example.PlaygroundApp.controller;

import com.example.PlaygroundApp.dto.StudentModel;
import com.example.PlaygroundApp.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @GetMapping("")
    public ResponseEntity<List<StudentModel>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentModel> getStudents(@PathVariable Long studentId){
        return ResponseEntity.ok(studentService.getStudent(studentId));
    }

    @PostMapping("/register")
    public ResponseEntity<String> addStudent(@RequestBody StudentModel studentModel){
        return ResponseEntity.ok(studentService.addStudent(studentModel));
    }

    @DeleteMapping("/remove/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        return ResponseEntity.ok(studentService.deleteStudent(studentId));
    }
}
