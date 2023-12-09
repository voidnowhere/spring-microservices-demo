package com.example.serviceclient.repositories;

import com.example.serviceclient.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
