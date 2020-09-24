package com.seu.ums_v1.Controller;

import com.seu.ums_v1.Entity.Phone;
import com.seu.ums_v1.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/management")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    //Fetch all
    @RequestMapping("/phones")
    public List<Phone> getAllPhone(){
        return phoneService.getAllPhone();
    }

    //Fetch one
    @RequestMapping("/phones/{id}")
    public Optional<Phone> getPhone(@PathVariable int id){
        return phoneService.getPhone(id);

    }
    //Fetch one
    @RequestMapping("/phones/p_no/{phone_no}")
    public Optional<Phone> getPhoneByPhone(@PathVariable String phone_no){
        return phoneService.getPhoneByPhoneNo(phone_no);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/phones/add")
    public void addPhone(@RequestBody Phone phone){
        phoneService.addPhone(phone);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/phones/update")
    public void updatePhone(@RequestBody Phone phone){
        phoneService.updatePhone(phone);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/phones/delete/{id}")
    public void deletePhone(@PathVariable int id){
        phoneService.deletePhone(id);
    }
}
