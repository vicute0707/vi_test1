package com.javademo.oder_service.config;

import org.springframework.context.annotation.*;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@ComponentScan("com.javademo.oder_service")
@EnableRedisRepositories(basePackages = "com.javademo.oder_service")
@PropertySource("classpath:application.properties")
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    @Bean
    public RedisTemplate<String,Object> redisTemplate(){
        final RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));

        return template;
    }

}
