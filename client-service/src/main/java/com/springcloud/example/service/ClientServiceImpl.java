package com.springcloud.example.service;

import com.springcloud.example.model.Client;
import com.springcloud.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<Client> findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client;
    }

    @Override
    public Client findByCpf(String cpf) {
        Client client = clientRepository.findByCpf(cpf);
        return client;
    }
}
