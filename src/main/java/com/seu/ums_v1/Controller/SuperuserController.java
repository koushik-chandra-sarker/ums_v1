package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Superuser;
import com.seu.ums_v1.Service.SuperuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/management")
public class SuperuserController {
    @Autowired
    private SuperuserService superuserService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Fetch all
    @RequestMapping(path = "/superuser")
    public List<Superuser> getAllSuperuser(){

        return superuserService.getAllSuperuser();
    }

    //Fetch one
    @RequestMapping("/superuser/{id}")
    public Optional<Superuser> getSuperuser(@PathVariable int id){
        return superuserService.getSuperuser(id);

    }

    //Insert
    @RequestMapping(method = RequestMethod.POST, path = "/superuser/add")
    public void addSuperuser(@RequestBody Superuser superuser){
        superuserService.addSuperuser(superuser);
    }

    @RequestMapping( path = "/superuser/create")
    public String createSuperuser(){
        return superuserService.createSuperuser();
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/superuser/update")
    public void updateSuperuser(@RequestBody Superuser superuser){
        superuserService.updateSuperuser(superuser);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/superuser/delete/{id}")
    public void deleteSuperuser(@PathVariable int id){
        superuserService.deleteSuperuser(id);
    }
}
