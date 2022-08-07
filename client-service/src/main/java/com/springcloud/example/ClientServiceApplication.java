package com.springcloud.example;

import com.springcloud.example.model.Client;
import com.springcloud.example.repository.ClientRepository;
import com.springcloud.example.util.CreateRandomRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class ClientServiceApplication {

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @PostConstruct
    @Transactional
    public void init() {
        List<Client> clients = new ArrayList<>();
        CreateRandomRegister crr = new CreateRandomRegister();
        for (int i = 0; i < 10; i++) {
            Client client = new Client();
            client.setName(crr.randomIdentifier());
            client.setCpf(crr.generateId());
            client.setCreatedAt(new Date());
            clients.add(client);
        }
        clientRepository.saveAll(clients);
    }
}
