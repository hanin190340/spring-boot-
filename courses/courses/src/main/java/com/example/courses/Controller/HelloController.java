package com.example.courses.Controller;

import com.example.courses.Entity.Courses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {
        private List<Courses> courseList = new ArrayList<>();
        private int idCounter = 1; ;
    @PostMapping("/create")
    public String createCourses(@RequestBody Courses requestObj) {
        requestObj.setId(idCounter);
        requestObj.setCreateDate(new Date());
        requestObj.setIsActive(true);
        courseList.add(requestObj);
        return "Courses created with ID: " + idCounter++;
    }

        @GetMapping("/getAll")
        public List <Courses> getAllCourses () {
            List<Courses> responseList = new ArrayList<>();
            for (Courses c: courseList) {
                if ((c.getIsActive())){
                    responseList.add(c);
                }

            }
            return responseList;
        }

        @GetMapping("/getById")
        public Courses getCourses (@RequestParam int id ){
            for (Courses c :courseList) {
                if (c.getId() == id && c.getIsActive()) {
                    return c;
                }
            }
return Courses.builder().build();
        }

    @PutMapping ("/Update")
        public String updateCourse (@RequestBody Courses updateObjFromUser ) {
            if (updateObjFromUser != null && updateObjFromUser.getId() != null) {
                Courses existingCourseToUpdate = findCourseById(updateObjFromUser.getId());
                courseList.remove(existingCourseToUpdate);
                existingCourseToUpdate.setName(updateObjFromUser.getName());
                existingCourseToUpdate.setLanguage(updateObjFromUser.getLanguage());
                existingCourseToUpdate.setInstructorName(updateObjFromUser.getInstructorName());
                existingCourseToUpdate.setUpdatedDate(new Date());
                courseList.add(existingCourseToUpdate);
                return "course updated successfully";
            }
            return "course not found";
        }
        @DeleteMapping("delete/{id}")
        public String deleteCourse (@PathVariable int id ) {
            Courses existingCourseToUpdate = findCourseById(id);
            if (existingCourseToUpdate.getId()>0){
                courseList.remove(existingCourseToUpdate);
                existingCourseToUpdate.setIsActive(false);
                existingCourseToUpdate.setUpdatedDate(new  Date());
                courseList.add(existingCourseToUpdate);
                return "Course deleted successfully";
            }
            return id + "Course not found";

        }
    public Courses findCourseById(int id) {
              for (Courses c : courseList) {
         if (c.getId() == id) {
                        return c;
                    }
              }
            return Courses.builder().id(-1).build();
            }


    }


