package com.ghani.online_course_mamagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghani.online_course_mamagement.DAO.StudentsJpa;
import com.ghani.online_course_mamagement.model.Student;

@Service
public class StudentService {

    private StudentsJpa studentrepo;

    public StudentService(StudentsJpa studentrepo) {
        this.studentrepo = studentrepo;
    }

    public Student createStudent(Student student) {
        Student addStudent = studentrepo.save(student);
        return addStudent;
    }

    public List<Student> getAllStudents() {
        return studentrepo.findAll();
    }

    public Student getStudentById(Long id) {

        Student student = studentrepo.findById(id).orElse(new Student());

        return student;
    }

    public Student updateStudent(Student student) {
        return studentrepo.save(student);
    }

    public void deleteStudent(long id) {
        studentrepo.deleteById(id);
    }

}
