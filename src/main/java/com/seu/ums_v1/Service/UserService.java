package com.seu.ums_v1.Service;


import com.seu.ums_v1.Entity.User;
import com.seu.ums_v1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username){
        Optional<User> user = userRepository.findUserByUsername(username);
        User u = null;
        if (user.isPresent()){
            u = user.get();
        }
        return u;
    }

    public void addUser(User User){
        userRepository.save(User);
    }

    public void updateUser(User User){
        userRepository.save(User);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
