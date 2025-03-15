package com.ghani.online_course_mamagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghani.online_course_mamagement.model.Student;
import com.ghani.online_course_mamagement.service.Services;

@RestController
public class AssiningController {

    private Services services;

    public AssiningController(Services services) {
        this.services = services;
    }

    // path="/student/1/course/2"
    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Student> assingCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        // Assining the course to the student
        // Long sId = Long.valueOf(studentId);
        // Long cId = Long.valueOf(courseId);

        return new ResponseEntity<>(services.assiningCourse(studentId, courseId), HttpStatus.CREATED);
    }

}
