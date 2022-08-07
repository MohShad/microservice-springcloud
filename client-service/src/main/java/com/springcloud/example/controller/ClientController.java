package com.springcloud.example.controller;

import com.springcloud.example.dto.ApiResponseDTO;
import com.springcloud.example.model.Client;
import com.springcloud.example.repository.ClientRepository;
import com.springcloud.example.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("getById/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {

        try {
            if (!clientRepository.existsById(id)) {
                return new ResponseEntity(new ApiResponseDTO(false, "Client ID not found."),
                        HttpStatus.NOT_FOUND);
            }
            Optional<Client> client = clientService.findById(id);

            return new ResponseEntity<Client>(client.get(), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return new ResponseEntity(new ApiResponseDTO(false, "Internal error: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByCpf/{cpf}")
    public ResponseEntity getClientByCpf(@PathVariable("cpf") String cpf) {

        try {
            if (!clientRepository.existsByCpf(cpf)) {
                return new ResponseEntity(new ApiResponseDTO(false, "CPF not found."),
                        HttpStatus.NOT_FOUND);
            }
            Client client = clientService.findByCpf(cpf);

            return new ResponseEntity<Client>(client, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return new ResponseEntity(new ApiResponseDTO(false, "Internal error: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
