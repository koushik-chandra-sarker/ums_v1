package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Campus;
import com.seu.ums_v1.Service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/management")
public class CampusController {
    @Autowired
    private CampusService campusService;
    @RequestMapping("/campuses")
    public List<Campus> getAllCampus(){
        return campusService.getAllCampus();
    }

    @RequestMapping("/campuses/{id}")
    public Optional<Campus> getCampus(@PathVariable int id){
        return campusService.getCampus(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/campuses/add")
    public void addCampus(@RequestBody Campus campus){
        campusService.addCampus(campus);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/campuses/update")
    public void updateCampus(@RequestBody Campus campus){
        campusService.updateCampus(campus);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/campuses/delete/{id}")
    public void deleteCampus(@PathVariable int id){
        campusService.deleteCampus(id);
    }
}
