package com.seu.ums_v1.Service;

import com.seu.ums_v1.Entity.Student;
import com.seu.ums_v1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudent(){
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
