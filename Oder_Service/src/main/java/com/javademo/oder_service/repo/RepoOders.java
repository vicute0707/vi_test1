package com.javademo.oder_service.repo;

import com.javademo.oder_service.entity.Order;
import com.javademo.oder_service.entity.User;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

@RedisHash
@Data
@EnableRedisRepositories
public class RepoOders implements Serializable {
    private Order order;
    private User user;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
