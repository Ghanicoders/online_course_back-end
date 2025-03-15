package com.ghani.online_course_mamagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghani.online_course_mamagement.model.Student;

@Repository
public interface StudentsJpa extends JpaRepository<Student, Long> {

}
