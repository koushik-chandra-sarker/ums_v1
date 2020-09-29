package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.*;
import com.seu.ums_v1.Service.LecturerService;
import com.seu.ums_v1.Service.SchoolService;
import com.seu.ums_v1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/management")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    //Fetch all
    @RequestMapping("/lecturers")
    public List<Lecturer> getAllLecturer(){
        return lecturerService.getAllLecturer();
    }

    //Fetch one
    @RequestMapping("/lecturers/{id}")
    public Optional<Lecturer> getLecturer(@PathVariable long id){
        return lecturerService.getLecturer(id);

    }
    //Fetch one
    @RequestMapping("/lecturers/school/{id}")
    public School getOnlySchool(@PathVariable int id){
        int schoolId=lecturerService.getSchoolId(id);
        Optional<School> school = schoolService.getSchool(schoolId);
        if (school.isPresent()){
            School s = school.get();
            s.setProgramme(new ArrayList<Programme>());
            s.setLecturers(new ArrayList<Lecturer>());
            return s;
        }


        return null;
    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/lecturers/add")
    public void addLecturer(@RequestBody Lecturer lecturer){
        lecturerService.addLecturer(lecturer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lecturers/createUser/{id}")
    public String createUser(@PathVariable long id) {
        Optional<Lecturer> lecturer = lecturerService.getLecturer(id);
        Lecturer lec = null;
        if (lecturer.isPresent()) {
            lec = lecturer.get();
        }

        String lid = String.valueOf(lec.getId());
        String lfname = lec.getFirstName();

        User user = userService.getUserByUsername(lfname+lid);
        if (user != null ){
            return "User Already Exists.";
        }else {
            User u = new User();
            u.setUsername(lfname + lid);
            u.setPassword(passwordEncoder.encode(lfname + lid));
            u.setLecturer(lec);
            u.setActive(true);
            u.setEmail(lec.getEmail());
            Role r = new Role();
            r.setRole("LECTURER");
            List<Role> role = new ArrayList<>();
            role.add(r);
            u.setRoles(role);
            userService.addUser(u);
            return "User Created Successful";
        }
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/lecturers/update")
    public void updateLecturer(@RequestBody Lecturer lecturer){
        lecturerService.updateLecturer(lecturer);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/lecturers/delete/{id}")
    public void deleteLecturer(@PathVariable long id){
        lecturerService.deleteLecturer(id);
    }
}
