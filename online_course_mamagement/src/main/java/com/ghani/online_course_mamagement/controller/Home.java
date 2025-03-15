package com.ghani.online_course_mamagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghani.online_course_mamagement.model.Student;
import com.ghani.online_course_mamagement.service.StudentService;

@RestController
public class Home {

    private StudentService services;

    public Home(StudentService services) {
        this.services = services;
    }

    @RequestMapping("/")
    public ResponseEntity<String> home() {

        return new ResponseEntity<>("Well come to online course management system", HttpStatus.OK);

    }

    @RequestMapping("/home")
    public ResponseEntity<List<Student>> students() {

        return new ResponseEntity<>(services.getAllStudents(), HttpStatus.OK);
    }
}
