package com.example.demo.config;

import com.example.demo.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemServiceConfig {
    @Bean
    public ItemService ItemService() {
        return new ItemService();
    }
}
