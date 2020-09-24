package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Lecturer;
import com.seu.ums_v1.Entity.Role;
import com.seu.ums_v1.Entity.Student;
import com.seu.ums_v1.Entity.User;
import com.seu.ums_v1.Repository.UserRepository;
import com.seu.ums_v1.Service.StudentService;
import com.seu.ums_v1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1/management")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Fetch all
    @RequestMapping(path = "/students")
    public List<Student> getAllStudent(){

        return studentService.getAllStudent();
    }

    //Fetch one
    @RequestMapping("/students/find/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.getStudent(id);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/students/createUser/{id}")
    public String createUser(@PathVariable long id) {
        Optional<Student> student = studentService.getStudent(id);
        Student std = null;
        if (student.isPresent()) {
            std = student.get();
        }

        String sid = String.valueOf(std.getId());
        String sfname = std.getFirstName();
        User user = userService.getUserByUsername(sfname+sid);
        if (user != null ){
            return "User Already created.";
        }else {
            User u = new User();
            u.setUsername(sfname + sid);
            u.setPassword(passwordEncoder.encode(sfname + sid));
            u.setStudent(std);
            u.setActive(true);
            u.setEmail(std.getEmail());
            Role r = new Role();
            r.setRole("STUDENT");
            List<Role> role = new ArrayList<>();
            role.add(r);
            u.setRoles(role);
            userService.addUser(u);
            return "User Created Successful";
        }
    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/students/add")
    public void addStudent(@RequestBody Student Student){
        studentService.addStudent(Student);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/students/update")
    public void updateStudent(@RequestBody Student Student){
        studentService.updateStudent(Student);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/students/delete/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }
}
