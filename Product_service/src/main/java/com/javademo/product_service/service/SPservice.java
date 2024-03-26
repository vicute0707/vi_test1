package com.javademo.product_service.service;

import com.javademo.product_service.entity.Product;
import com.javademo.product_service.repo.RepositoriSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class SPservice {
    @Autowired
    private RepositoriSP repositoriSP;

    public SPservice(RepositoriSP repositoriSP) {
        this.repositoriSP = repositoriSP;
    }

    public List<Product> getAllSP(){
        List<Product> list = new ArrayList<>();
        repositoriSP.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Product findByIDProduct(Integer id){
        Product product = repositoriSP.findById(id).get();
        return product;
    }
    public Product themSPmoi(@RequestBody Product product){
        repositoriSP.save(product);
        return product;
    }
    public void DeleteSP(@PathVariable Integer id){
        repositoriSP.deleteById(id);
    }
    public void updateSP(@RequestBody Product product){
        repositoriSP.save(product);
    }

}
