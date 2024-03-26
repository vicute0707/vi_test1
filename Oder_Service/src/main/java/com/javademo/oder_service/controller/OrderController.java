package com.javademo.oder_service.controller;

import com.javademo.oder_service.entity.Order;
import com.javademo.oder_service.entity.User;
import com.javademo.oder_service.repo.RepoOders;
import com.javademo.oder_service.repo.RepoOrder;
import com.javademo.oder_service.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OderService oderService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RepoOrder repoOrder;

    @GetMapping("/order")
    public List<Order> getALLOrder(){
        return oderService.getALLOrder();
    }
    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order){

        return oderService.addOder(order);
    }
    @GetMapping("/order/{id}")
    public Order findByIDOrder(@PathVariable Integer id){
        return oderService.findByID(id);
    }

    @GetMapping("/oder_user/{id}/{oid}")
    @Cacheable(value = "useror")
    public RepoOders orderUser(@PathVariable Integer id, @PathVariable Integer oid){
        RepoOders repoOders = new RepoOders();
        String url="http://localhost:8083/api/user/" + id;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        Optional<Order> optional = repoOrder.findById(oid);
        Order order =null;
        if (optional.isPresent()) {
            order = optional.get();
        }
        User user = response.getBody();
        repoOders.setOrder(order);
        repoOders.setUser(user);
        return repoOders;
    }
}