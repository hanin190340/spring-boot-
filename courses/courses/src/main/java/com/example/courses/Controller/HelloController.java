package com.example.courses.Controller;

import com.example.courses.Entity.Courses;
import com.example.courses.Service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {
    @Autowired
    CoursesService coursesService;

    @PostMapping("/create")
    public Courses createCourses(@RequestBody Courses requestObj) {
        Courses courses = coursesService.saveCourse(requestObj);
        requestObj.setCreateDate(new Date());
        requestObj.setIsActive(true);
        return courses;

    }

    @GetMapping("/getAll")
    public List<Courses> getAllCourses() {
        List<Courses> responseList = coursesService.getAllCourses();
        System.out.println(responseList);
        return responseList;
    }

    @GetMapping("/getById")
    public Courses getCourses(@RequestParam int id) throws Exception {

        return coursesService.getCourseById(id);
    }

    @PutMapping("/Update")
    public Courses updateCourse(@RequestBody Courses updateObjFromUser) throws Exception {

        return coursesService.updateCourse(updateObjFromUser);
    }

    @DeleteMapping("/delete")
    public String deleteCourse(@RequestParam int id) throws Exception {
        coursesService.deleteCourse(id);
        return "Course deleted successfully";
    }


}



