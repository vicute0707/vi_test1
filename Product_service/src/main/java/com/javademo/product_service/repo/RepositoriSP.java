package com.javademo.product_service.repo;

import com.javademo.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoriSP extends JpaRepository<Product,Integer> {
}
