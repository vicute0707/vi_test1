package com.javademo.oder_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("ordor")
public class Order implements Serializable {
    @Id
    private int id;

    private String diachi;

    private LocalDate ngay;

}
