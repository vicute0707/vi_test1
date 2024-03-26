package com.javademo.oder_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestempleConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
