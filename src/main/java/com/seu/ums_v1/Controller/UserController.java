package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.User;
import com.seu.ums_v1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "api/v1/management")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Fetch all
    @RequestMapping(path = "/users")
    public List<User> getAllUser(){

        return userService.getAllUser();
    }

    //Fetch one
    @RequestMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return userService.getUser(id);

    }
    //Fetch one
    @RequestMapping("/users/uname/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUserByUsername(username);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, path = "/users/add")
    public void addUser(@RequestBody User User){
        String pass = User.getPassword();
        String encryptPwd = passwordEncoder.encode(pass);
        User.setPassword(encryptPwd);
        userService.addUser(User);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/users/update")
    public void updateUser(@RequestBody User User){
        userService.updateUser(User);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
