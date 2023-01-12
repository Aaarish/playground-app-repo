package com.example.PlaygroundApp.service;

import com.example.PlaygroundApp.converter.StudentConverter;
import com.example.PlaygroundApp.dao.StudentRepo;
import com.example.PlaygroundApp.dto.StudentModel;
import com.example.PlaygroundApp.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentConverter studentConverter;

    @Override
    public List<StudentModel> getStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentModel> studentModels = new ArrayList<>();

        students.forEach(s -> studentModels.add(studentConverter.convertEntityToModel(s)));

        return studentModels;
    }

    @Override
    public StudentModel getStudent(Long studentId) {
        Student student = studentRepo.findByStudentId(studentId);
        return studentConverter.convertEntityToModel(student);
    }

    @Override
    public String addStudent(StudentModel studentModel) {
        Student student = studentConverter.convertModelToEntity(studentModel);
        Student registeredStudent = studentRepo.save(student);

        return registeredStudent.getStudentName();
    }

    @Override
    public String deleteStudent(Long studentId) {
        Student student = studentRepo.findByStudentId(studentId);
        studentRepo.delete(student);

        return "deleted";
    }
}
