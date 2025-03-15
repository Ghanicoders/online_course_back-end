package com.ghani.online_course_mamagement.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ghani.online_course_mamagement.DAO.CourseJpa;
import com.ghani.online_course_mamagement.DAO.InstructorJpa;
import com.ghani.online_course_mamagement.DAO.StudentsJpa;
import com.ghani.online_course_mamagement.model.Course;
import com.ghani.online_course_mamagement.model.Student;

@Service
public class Services {

    private StudentService studentService;
    private CourseService courseService;
    private InstructorService instructorService;

    private StudentsJpa studentjpa;
    private CourseJpa coursejpa;
    private InstructorJpa instructorjpa;

    public Services(StudentService stuService, CourseService courService, InstructorService instService,

            StudentsJpa stuJpa, CourseJpa courJpa, InstructorJpa instJpa) {
        this.studentService = stuService;
        this.courseService = courService;
        this.instructorService = instService;

        this.studentjpa = stuJpa;
        this.coursejpa = courJpa;
        this.instructorjpa = instJpa;
    }

    public Student assiningCourse(Long studentId, Long courseId) {
        Set<Course> courseset = null;
        Student s = studentjpa.findById(studentId).get();
        Course c = coursejpa.findById(courseId).get();

        courseset.add(c);
        s.setCourses(courseset);

        return studentjpa.save(s);
    }

}
