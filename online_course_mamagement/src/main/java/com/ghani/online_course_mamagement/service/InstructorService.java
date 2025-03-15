package com.ghani.online_course_mamagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghani.online_course_mamagement.DAO.InstructorJpa;
import com.ghani.online_course_mamagement.model.Instructor;

@Service
public class InstructorService {

    private InstructorJpa instructorrepo;

    public InstructorService(InstructorJpa instructorrepo) {
        this.instructorrepo = instructorrepo;
    }

    public Instructor addInstructor(Instructor instructor) {
        return instructorrepo.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorrepo.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorrepo.findById(id).orElse(new Instructor());
    }

    public Instructor updateInstructor(Instructor instructor) {
        return instructorrepo.save(instructor);
    }

    public void deleteInstructor(Long id) {
        instructorrepo.deleteById(id);
    }
}
