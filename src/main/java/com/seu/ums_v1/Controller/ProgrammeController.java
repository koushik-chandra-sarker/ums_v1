package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Programme;
import com.seu.ums_v1.Service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/management")
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    //Fetch all
    @RequestMapping("/programmes")
    public List<Programme> getAllProgramme(){
        return programmeService.getAllProgramme();
    }

    //Fetch one
    @RequestMapping("/programmes/{code}")
    public Optional<Programme> getProgramme(@PathVariable String code){
        return programmeService.getProgramme(code);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/programmes/add")
    public void addProgramme(@RequestBody Programme programme){
        programmeService.addProgramme(programme);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/programmes/update")
    public void updateProgramme(@RequestBody Programme programme){
        programmeService.updateProgramme(programme);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/programmes/delete/{code}")
    public void deleteProgramme(@PathVariable String code){
        programmeService.deleteProgramme(code);
    }
}
