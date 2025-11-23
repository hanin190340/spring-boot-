package com.example.courses.Service;

import com.example.courses.Entity.Courses;
import com.example.courses.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Courses saveCourse(Courses courses) {
        courses.setCreateDate(new Date());
        courses.setIsActive(Boolean.TRUE);
        return coursesRepository.save(courses);
    }

    public Courses updateCourse(Courses courses) throws Exception {
        Courses existingCourses = coursesRepository.findById(courses.getId()).get();

        if (existingCourses != null && existingCourses.getIsActive()) {
            courses.setUpdatedDate(new Date());
            return coursesRepository.save(courses);
        } else {
            throw new Exception("Course not found");

        }
    }

    public void deleteCourse(Integer id) throws Exception {
        Courses existingCourse = coursesRepository.findById(id).get();
        System.out.println(existingCourse.getIsActive());
        if (existingCourse != null && existingCourse.getIsActive()) {
            existingCourse.setUpdatedDate(new Date());
            existingCourse.setIsActive(false);
            coursesRepository.save(existingCourse);
        } else {
            throw new Exception("Course not found");
        }
    }


    public Courses getCourseById(Integer id) throws Exception {
        Courses existingCourses = coursesRepository.findById(id).get();
        if (existingCourses != null && existingCourses.getIsActive()) {
            return existingCourses;
        } else {
            throw new Exception("Course not found");
        }
    }
}
