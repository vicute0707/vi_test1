package com.javademo.product_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
@Table(name="tbt_product")
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer id;
    @Column(name = "product_name")
    private String name_sp;

    public Product(Integer id, String name_sp) {
        this.id = id;
        this.name_sp = name_sp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_sp() {
        return name_sp;
    }

    public void setName_sp(String name_sp) {
        this.name_sp = name_sp;
    }
}
