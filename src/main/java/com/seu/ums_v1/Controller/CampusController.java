package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Campus;
import com.seu.ums_v1.Entity.School;
import com.seu.ums_v1.Service.CampusService;
import com.seu.ums_v1.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/management")
public class CampusController {
    @Autowired
    private CampusService campusService;
    @Autowired
    private SchoolService schoolService;


    @RequestMapping("/campuses")
    public List<Campus> getAllCampus() {
        return campusService.getAllCampus();
    }

    @RequestMapping("/campuses/{id}")
    public Optional<Campus> getCampus(@PathVariable int id) {
        return campusService.getCampus(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/campuses/add")
    public void addCampus(@RequestBody Campus campus) {
        campusService.addCampus(campus);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/campuses/update")
    public void updateCampus(@RequestBody Campus campus) {
        campusService.updateCampus(campus);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/campuses/delete/{id}")
    public void deleteCampus(@PathVariable int id) {

        Optional<Campus> campus = campusService.getCampus(id);
        Campus campus1 = null;
        if (campus.isPresent()) {
            campus1 = campus.get();
        }
        assert campus1 != null;
        for (int i = 0; i < campus1.getSchool().size(); i++) {
            schoolService.deleteCampusBySid(campus1.getSchool().get(i).getId());
        }
        campusService.deleteCampus(id);

    }
}
