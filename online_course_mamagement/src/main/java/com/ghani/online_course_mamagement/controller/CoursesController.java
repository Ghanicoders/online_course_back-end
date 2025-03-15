package com.ghani.online_course_mamagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ghani.online_course_mamagement.model.Course;
import com.ghani.online_course_mamagement.service.CourseService;

@RestController
public class CoursesController {

    private CourseService service;

    public CoursesController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/course{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {

        return new ResponseEntity<>(service.getCourseById(id), HttpStatus.OK);
    }

    @PostMapping("/course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(service.addCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/course")
    public ResponseEntity<Course> uppdateCourse(@RequestBody Course course) {
        return new ResponseEntity<>(service.updateCourse(course), HttpStatus.OK);
    }

    @DeleteMapping("/course{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);

        return new ResponseEntity<>("Course deleted", HttpStatus.OK);
    }

}
