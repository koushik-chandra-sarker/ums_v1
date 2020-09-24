package com.seu.ums_v1.Service;


import com.seu.ums_v1.Entity.School;
import com.seu.ums_v1.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SchoolService {


    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getAllSchool(){
        return (List<School>) schoolRepository.findAll();
    }

    public Optional<School> getSchool(int id){
        return schoolRepository.findById(id);
    }

    public void addSchool(School school){
        schoolRepository.save(school);
    }

    public void updateSchool(School school){
        schoolRepository.save(school);
    }

    public void deleteSchool(int id){
        schoolRepository.deleteById(id);
    }
}
