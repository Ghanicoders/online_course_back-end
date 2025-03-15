package com.ghani.online_course_mamagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ghani.online_course_mamagement.model.Student;
import com.ghani.online_course_mamagement.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;

    }

    @RequestMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {

        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);

    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = service.createStudent(student);

        return new ResponseEntity<Student>(addedStudent, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = service.getStudentById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = service.updateStudent(student);

        return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable Long id) {
        service.deleteStudent(id);

        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}
