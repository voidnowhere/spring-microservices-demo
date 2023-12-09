package com.example.serviceclient;

import com.example.serviceclient.entities.Client;
import com.example.serviceclient.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client("Rabab SELIMANI", 22));
            clientRepository.save(new Client("Amal RAMI", 22));
            clientRepository.save(new Client("Samir SAFI", 23));
        };
    }
}
