package com.seu.ums_v1.Service;

import com.seu.ums_v1.Entity.Course_Student;
import com.seu.ums_v1.Repository.CourseStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseStudentService {


    @Autowired
    private CourseStudentRepository courseStudentRepository;


    public List<Course_Student> getAllCourse_Student(){
        return (List<Course_Student>) courseStudentRepository.findAll();
    }
    public List<Course_Student> getAllCourse_StudentByCourseSsn(String ssn){
        return courseStudentRepository.findAllByCoursesSsn(ssn);
    }

    public List<Course_Student> getAllCourse_StudentBySId(int sid){
        return courseStudentRepository.findAllByStudentId(sid);
    }

    public Optional<Course_Student> getCourse_Student(String ssn){
        return courseStudentRepository.findById(ssn);
    }

    public void addCourse_Student(Course_Student Course_Student){
        courseStudentRepository.save(Course_Student);
    }

    public void updateCourse_Student(Course_Student Course_Student){
        courseStudentRepository.save(Course_Student);
    }

    public void deleteCourse_Student(String ssn){
        courseStudentRepository.deleteById(ssn);
    }
}
