package com.example.courses.Repository;

import com.example.courses.Entity.Courses;
import com.example.courses.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstuctorRepository extends JpaRepository<Instructor, Integer> {
}
