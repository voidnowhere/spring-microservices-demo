package com.example.servicecar;

import com.example.servicecar.dtos.Client;
import com.example.servicecar.entities.Car;
import com.example.servicecar.repositories.CarRepository;
import com.example.servicecar.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ServiceCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCarApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(CarRepository carRepository, ClientService clientService) {
        return args -> {
            Client c1 = clientService.getClientById(2L);
            Client c2 = clientService.getClientById(1L);
            System.out.println("**************************");
            System.out.println("Id est :" + c2.getId());
            System.out.println("Nom est :" + c2.getNom());
            System.out.println("**************************");
            System.out.println("**************************");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getNom());
            System.out.println("Age est :" + c1.getAge());
            System.out.println("**************************");
            carRepository.save(new Car("Toyota", "A 25 333", "Corolla", c2.getId(), c2));
            carRepository.save(new Car("Renault", "B 6 3456", "Megane", c2.getId(), c2));
            carRepository.save(new Car("Peugeot", "A 55 4444", "301", c1.getId(), c1));
        };
    }
}
