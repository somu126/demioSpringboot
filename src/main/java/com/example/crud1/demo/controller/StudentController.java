package com.example.crud1.demo.controller;

import com.example.crud1.demo.model.Student1;
import com.example.crud1.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student") // Base path for all student routes
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody Student1 student1) {
        studentService.add(student1);
    }

    @GetMapping
    public List<Student1> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}") // Ensure PathVariable name matches method parameter
    public Student1 getStudentById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public Student1 updateStudent(@RequestBody Student1 student1, @PathVariable Long id) {
        return studentService.updateStudent(id, student1);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
