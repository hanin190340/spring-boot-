package com.example.Spring.Boot;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class CRUDApis {
    private Map<Integer, String> courses = new HashMap<>();
    private  int idCounter = 1 ;
    @PostMapping("create")
    public String createCourses(@RequestParam String name) {
        courses.put(idCounter, name);
        return "Courses created with ID: " + idCounter++;
    }
    @GetMapping("getAll")
    public Map <Integer, String> getCourses () {
        return courses;
    }
    @GetMapping("getById")
    public String getCourses (@RequestParam int id ){
        return courses.getOrDefault(id, "courses not found");

    }
    @PutMapping ("Update")
    public String updateCourse (@RequestParam int id,@RequestParam String name) {
        if (courses.containsKey(id)) {
            courses.put(id, name);
            return "course updated successfully";
        }
        return "course not found";
    }
    @DeleteMapping("delete/{id}")
    public String deleteCourse (@PathVariable int id ) {
        if (courses.remove(id) !=null){
            return "Course deleted successfully";
        }
        return id + "Course not found";

    }




}
