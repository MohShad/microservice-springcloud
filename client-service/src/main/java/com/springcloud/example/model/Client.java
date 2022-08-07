package com.springcloud.example.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

}
