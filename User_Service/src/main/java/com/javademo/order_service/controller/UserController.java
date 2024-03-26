package com.javademo.order_service.controller;

import com.javademo.order_service.entity.User;
import com.javademo.order_service.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ServiceUser serviceUser;
    @GetMapping("/user")
    List<User> getALLUser (){
        return serviceUser.getAllSP();
    }
    @PostMapping("/user")
    User themSP(@RequestBody User user){
        return serviceUser.addUser(user);
    }
    @GetMapping("user/{id}")
    User findByidUser(@PathVariable Integer id){
        return serviceUser.findByIDUser(id);
    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id){
         serviceUser.deleteUser(id);
         return "Xoa thanh cong";
    }
    @PutMapping("/user")
    public String update(@RequestBody User user){
        serviceUser.update(user);
        return "update thanh cong";
    }

}
