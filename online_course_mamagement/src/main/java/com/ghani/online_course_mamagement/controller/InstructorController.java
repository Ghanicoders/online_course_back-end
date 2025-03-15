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
import com.ghani.online_course_mamagement.model.Instructor;
import com.ghani.online_course_mamagement.service.InstructorService;

@RestController
public class InstructorController {

    private InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;

    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructor() {
        return new ResponseEntity<>(service.getAllInstructors(), HttpStatus.OK);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getInstructorById(id), HttpStatus.OK);
    }

    @PostMapping("/instructor")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {

        return new ResponseEntity<>(service.addInstructor(instructor), HttpStatus.OK);
    }

    @PutMapping("/instructor")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(service.updateInstructor(instructor), HttpStatus.OK);
    }

    @DeleteMapping("/instructor/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long id) {
        service.deleteInstructor(id);
        return new ResponseEntity<>("Instructor with id " + id + " deleted successfully", HttpStatus.OK);
    }

}
