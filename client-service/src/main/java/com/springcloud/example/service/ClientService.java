package com.springcloud.example.service;

import com.springcloud.example.model.Client;

import java.util.Optional;

public interface ClientService {

    Optional<Client> findById(Long id);

    Client findByCpf(String cpf);
}
