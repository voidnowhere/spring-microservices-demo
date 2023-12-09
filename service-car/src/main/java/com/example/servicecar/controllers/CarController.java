package com.example.servicecar.controllers;

import com.example.servicecar.entities.Car;
import com.example.servicecar.repositories.CarRepository;
import com.example.servicecar.services.CarService;
import com.example.servicecar.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    final CarRepository repository;
    final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> get(@PathVariable Long id) {
        Optional<Car> car = repository.findById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Car>> getAllByClientId(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findAllByClientId(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Car car) {
        repository.save(car);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Car car) {
        repository.save(car);
        return ResponseEntity.ok().build();
    }
}
