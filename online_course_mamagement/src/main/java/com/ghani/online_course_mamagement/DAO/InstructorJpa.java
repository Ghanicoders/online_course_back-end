package com.ghani.online_course_mamagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghani.online_course_mamagement.model.Instructor;

@Repository
public interface InstructorJpa extends JpaRepository<Instructor, Long> {

}
