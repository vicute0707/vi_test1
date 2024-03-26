package com.javademo.order_service.service;

import com.javademo.order_service.entity.User;
import com.javademo.order_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceUser {
    @Autowired
    private UserRepo userRepo;
    public List<User> getAllSP(){
        List<User> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    public User addUser(@RequestBody User user){
        userRepo.save(user);
        return user;
    }
    public User findByIDUser(@PathVariable Integer id){
        User user = userRepo.findById(id).get();
        return user;
    }
    public void deleteUser(@PathVariable Integer id){
        userRepo.deleteById(id);
    }
    public User update(@RequestBody User user){
        userRepo.save(user);
        return user;
    }
}
