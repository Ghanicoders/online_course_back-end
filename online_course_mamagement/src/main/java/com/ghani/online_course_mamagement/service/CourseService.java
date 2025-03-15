package com.ghani.online_course_mamagement.service;

import com.ghani.online_course_mamagement.model.Course;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghani.online_course_mamagement.DAO.CourseJpa;

@Service
public class CourseService {

    private CourseJpa courseJpa;

    public CourseService(CourseJpa courseJpa) {
        this.courseJpa = courseJpa;

    }

    public Course addCourse(Course course) {
        return courseJpa.save(course);
    }

    public List<Course> getAllCourses() {

        return courseJpa.findAll();
    }

    public Course getCourseById(Long id) {
        return courseJpa.findById(id).orElse(new Course());
    }

    public Course updateCourse(Course course) {
        return courseJpa.save(course);
    }

    public void deleteCourse(Long id) {
        courseJpa.deleteById(id);
    }

}