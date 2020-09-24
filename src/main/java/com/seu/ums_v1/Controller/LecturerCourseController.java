package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Lecturer;
import com.seu.ums_v1.Entity.Lecturer_Course;
import com.seu.ums_v1.Service.LecturerService;
import com.seu.ums_v1.Service.Lecturer_CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/management")
public class LecturerCourseController {
    @Autowired
    private Lecturer_CourseService lecturer_courseService;

    @Autowired
    private LecturerService lecturerService;

    //Fetch all
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @RequestMapping("/lecturer_courses")
    public List<Lecturer_Course> getAllLecturer_Course(){
        return lecturer_courseService.getAllLecturer_Course();
    }

    //Fetch one
    @RequestMapping("/lecturer_courses/{ssn}")
    public Optional<Lecturer_Course> getLecturer_Course(@PathVariable String ssn){
        return lecturer_courseService.getLecturer_Course(ssn);

    }
    @RequestMapping("/lecturer_courses/lec/{lid}")
    public List<Lecturer_Course> getLecturer_Course(@PathVariable int lid){
        return lecturer_courseService.getAllLecturer_CourseByLId(lid);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/lecturer_courses/add")
    public void addLecturer_Course(@RequestBody Lecturer_Course Lecturer_Course) {
        Optional<Lecturer> lecturer = lecturerService.getLecturer(Lecturer_Course.getLecturer().getId());
        Lecturer lec = null;
        if (lecturer.isPresent()) {
            lec = lecturer.get();
        }
        String CCode = Lecturer_Course.getCourse().getCode();
        String LInitial = lec.getInitial();
        Lecturer_Course.setSsn(CCode+"-"+LInitial);
        lecturer_courseService.addLecturer_Course(Lecturer_Course);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/lecturer_courses/update")
    public void updateLecturer_Course(@RequestBody Lecturer_Course Lecturer_Course){
        lecturer_courseService.updateLecturer_Course(Lecturer_Course);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/lecturer_courses/delete/{ssn}")
    public void deleteLecturer_Course(@PathVariable String ssn){
        lecturer_courseService.deleteLecturer_Course(ssn);
    }
}
