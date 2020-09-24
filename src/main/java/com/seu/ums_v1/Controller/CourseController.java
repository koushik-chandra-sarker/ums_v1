package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Course;
import com.seu.ums_v1.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("api/v1/management")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //Fetch all
    @RequestMapping("/courses")
    public List<Course> getAllCourse(){

        return courseService.getAllCourse();
    }

    //Fetch one
    @RequestMapping("/courses/{code}")
    public Optional<Course> getCourse(@PathVariable String code){
        return courseService.getCourse(code);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/courses/add")
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/courses/update")
    public void updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
    }
    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/delete/{code}")
    public void deleteCourse(@PathVariable String code){
        courseService.deleteCourse(code);
    }


}
