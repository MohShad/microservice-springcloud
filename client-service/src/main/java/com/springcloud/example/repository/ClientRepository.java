package com.springcloud.example.repository;

import com.springcloud.example.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);

    boolean existsById(Long id);

    Client findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}
