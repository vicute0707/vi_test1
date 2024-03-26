package com.javademo.oder_service.service;

import com.javademo.oder_service.entity.Order;
import com.javademo.oder_service.entity.User;
import com.javademo.oder_service.repo.RepoOders;
import com.javademo.oder_service.repo.RepoOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OderService {

    @Autowired
    RepoOrder repoOrder;
    @Autowired
    RestTemplate restTemplate = new RestTemplate();
    public List<Order> getALLOrder(){
        List<Order> list = new ArrayList<>();
        repoOrder.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    public Order addOder(@RequestBody Order order){
        repoOrder.save(order);
        return order;
    }
    public Order findByID(@PathVariable Integer id){
        Order order =  repoOrder.findById(id).get();
        return order;
    }

}
