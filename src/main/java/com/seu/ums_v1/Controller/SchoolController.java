package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.School;
import com.seu.ums_v1.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/management")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/schools")
    public List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }

    @RequestMapping("/schools/{id}")
    public Optional<School> getSchool(@PathVariable int id){
        return schoolService.getSchool(id);

    }

    @RequestMapping(method = RequestMethod.POST,value = "/schools/add")
    public void addSchool(@RequestBody School school){
        System.out.println(school);
        schoolService.addSchool(school);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/schools/update")
    public void updateSchool(@RequestBody School school){
        schoolService.updateSchool(school);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/schools/delete/{id}")
    public void deleteSchool(@PathVariable int id){
        schoolService.deleteSchool(id);
    }

}
