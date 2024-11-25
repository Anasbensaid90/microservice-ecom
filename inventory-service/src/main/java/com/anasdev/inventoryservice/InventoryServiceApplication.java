package com.anasdev.inventoryservice;

import com.anasdev.inventoryservice.entities.Product;
import com.anasdev.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("pc")
                    .price(10000)
                    .quantity(2)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("tilifon")
                    .price(100)
                    .quantity(5)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}
