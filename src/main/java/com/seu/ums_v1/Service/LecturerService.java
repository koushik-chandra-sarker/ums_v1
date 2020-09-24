package com.seu.ums_v1.Service;

import com.seu.ums_v1.Entity.Lecturer;
import com.seu.ums_v1.Repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LecturerService {


    @Autowired
    private LecturerRepository lecturerRepository;


    public List<Lecturer> getAllLecturer(){
        return (List<Lecturer>) lecturerRepository.findAll();
    }

    public Optional<Lecturer> getLecturer(long id){
        return lecturerRepository.findById(id);
    }

    public void addLecturer(Lecturer lecturer){
        lecturerRepository.save(lecturer);
    }

    public void updateLecturer(Lecturer lecturer){
        lecturerRepository.save(lecturer);
    }

    public void deleteLecturer(long id){
        lecturerRepository.deleteById(id);
    }
}
