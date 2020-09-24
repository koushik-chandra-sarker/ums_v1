package com.seu.ums_v1.Controller;


import com.seu.ums_v1.Entity.Course;
import com.seu.ums_v1.Entity.Course_Student;
import com.seu.ums_v1.Service.CourseService;
import com.seu.ums_v1.Service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/management")
public class CourseStudentController {
    @Autowired
    private CourseStudentService courseStudentService;
    @Autowired
    private CourseService courseService;

    //Fetch all
    @RequestMapping("/student_courses")
    public List<Course_Student> getAllCourse_Student(){
        return courseStudentService.getAllCourse_Student();
    }
    @RequestMapping("/student_courses/course/{ssn}")
    public List<Course_Student> getAllCourse_StudentByCourseSsn(@PathVariable String ssn){
        return courseStudentService.getAllCourse_StudentByCourseSsn(ssn);
    }

    //Fetch one
    @RequestMapping("/student_courses/{ssn}")
    public Optional<Course_Student> getCourse_Student(@PathVariable String ssn){
        return courseStudentService.getCourse_Student(ssn);

    }
    //Fetch one
    @RequestMapping("/student_courses/std/{sid}")
    public List<Course_Student> getAllCourse_StudentBySId(@PathVariable int sid){
        return courseStudentService.getAllCourse_StudentBySId(sid);

    }

    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/student_courses/add")
    public void addCourse_Student(@RequestBody Course_Student Course_Student){

        String CCode=Course_Student.getCourses().getSsn();
        Long sid = Course_Student.getStudent().getId();

        Optional<Course> course = courseService.getCourse(CCode.split("-")[0]);
        Course_Student.setSsn(sid+"-"+CCode);
        Course_Student.setCourseTitle(course.get().getTitle());
        courseStudentService.addCourse_Student(Course_Student);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/student_courses/update")
    public void updateCourse_Student(@RequestBody Course_Student Course_Student){
        courseStudentService.updateCourse_Student(Course_Student);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/student_courses/delete/{ssn}")
    public void deleteCourse_Student(@PathVariable String ssn){
        courseStudentService.deleteCourse_Student(ssn);
    }
}
