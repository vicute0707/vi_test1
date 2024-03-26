package com.javademo.product_service.controller;

import com.javademo.product_service.entity.Product;
import com.javademo.product_service.service.SPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SPcontroller {
    @Autowired
    private SPservice sPservice;
    @PostMapping("/product")
    Product themSP(@RequestBody Product product){

        return sPservice.themSPmoi(product);
    }
    @GetMapping("/product")
     List<Product> getALLSP(){
        List<Product> list = new ArrayList<>();
        sPservice.getAllSP().iterator().forEachRemaining(list::add);
        return list;
    }
    @GetMapping("/product/{id}")
    Product findBYSPid (@PathVariable int id){
        return sPservice.findByIDProduct(id);
    }

    @DeleteMapping("/product/{id}")
    String deleteSP(@PathVariable int id){
        sPservice.DeleteSP(id);
        return "Xoa Thanh cong";
    }
    @PutMapping("/product")
    String updateSP(@RequestBody Product product){
        sPservice.updateSP(product);
        return "Cap nhat thanh cong";
    }

}
