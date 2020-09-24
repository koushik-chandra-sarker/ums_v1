package com.seu.ums_v1.Service;

import com.seu.ums_v1.Entity.Lecturer_Course;
import com.seu.ums_v1.Repository.Lecturer_CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class Lecturer_CourseService {


    @Autowired
    private Lecturer_CourseRepository lecturer_courseRepository;


    public List<Lecturer_Course> getAllLecturer_Course(){
        return (List<Lecturer_Course>) lecturer_courseRepository.findAll();
    }
    public List<Lecturer_Course> getAllLecturer_CourseByLId(int LId){
        return (List<Lecturer_Course>) lecturer_courseRepository.findAllByLecturer(LId);
    }

    public Optional<Lecturer_Course> getLecturer_Course(String ssn){
        return lecturer_courseRepository.findById(ssn);
    }

    public void addLecturer_Course(Lecturer_Course Lecturer_Course){
        lecturer_courseRepository.save(Lecturer_Course);
    }

    public void updateLecturer_Course(Lecturer_Course Lecturer_Course){
        lecturer_courseRepository.save(Lecturer_Course);
    }

    public void deleteLecturer_Course(String ssn){
        lecturer_courseRepository.deleteById(ssn);
    }
}
