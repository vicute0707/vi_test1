package com.javademo.oder_service.repo;

import com.javademo.oder_service.entity.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoOrder extends CrudRepository<Order, Integer> {

}
