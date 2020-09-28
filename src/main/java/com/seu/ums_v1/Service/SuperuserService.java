package com.seu.ums_v1.Service;


import com.seu.ums_v1.Entity.Role;
import com.seu.ums_v1.Entity.Superuser;
import com.seu.ums_v1.Entity.User;
import com.seu.ums_v1.Repository.SuperuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SuperuserService {


    @Autowired
    private SuperuserRepository superuserRepository;
    @Autowired
    private  UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Superuser> getAllSuperuser(){
        return superuserRepository.findAll();
    }

    public Optional<Superuser> getSuperuser(int id){
        return superuserRepository.findById(id);
    }
    public Superuser getSuperuserByEmail(String email){
        return superuserRepository.findSuperuserByEmail(email);
    }
    public String createSuperuser(){
        List<User> users = userService.getAllUser();
        if (users.isEmpty()){
            Superuser superuser = new Superuser("Admin","","","admin@admin.com");
            superuserRepository.save(superuser);
            Superuser superuser1 = superuserRepository.findSuperuserByEmail("admin@admin.com");
            User u = new User();
            u.setUsername("admin");
            u.setPassword(passwordEncoder.encode("admin"));
            u.setSuperuser(superuser1);
            u.setActive(true);
            u.setEmail(superuser1.getEmail());
            Role r = new Role();
            r.setRole("ADMIN");
            List<Role> role = new ArrayList<>();
            role.add(r);
            u.setRoles(role);
            userService.addUser(u);
            return "Superuser Successfully Created.";
        }
        else {
            return "Superuser Already  Existed.";
        }

    }

    public void addSuperuser(Superuser superuser){
        superuserRepository.save(superuser);
    }

    public void updateSuperuser(Superuser superuser){
        superuserRepository.save(superuser);
    }

    public void deleteSuperuser(int id){
        superuserRepository.deleteById(id);
    }
}
