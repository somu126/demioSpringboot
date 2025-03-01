package com.example.crud1.demo.service;

import com.example.crud1.demo.model.Student1;
import com.example.crud1.demo.repository.Student1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private Student1Repository student1Repository;

    // Add a new student
    public void addStudent(Student1 student1) {
        student1Repository.save(student1);
    }

    // Retrieve all students
    public List<Student1> getAllStudents() {
        return student1Repository.findAll();
    }

    // Retrieve student by ID with proper handling
    public Student1 getStudentById(Long id) {
        return student1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    // Update student details
    public Student1 updateStudent(Long id, Student1 student1) {
        Student1 existingStudent = student1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

        existingStudent.setName(student1.getName());
        existingStudent.setBranch(student1.getBranch());
        existingStudent.setRollnumber(student1.getRollnumber());

        return student1Repository.save(existingStudent);
    }

    // Delete student by ID
    public void deleteStudentById(Long id) {
        Student1 student1 = student1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
        student1Repository.delete(student1);
    }
}
