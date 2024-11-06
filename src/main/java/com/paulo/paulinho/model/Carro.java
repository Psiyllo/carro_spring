package com.paulo.paulinho.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String model;
    private Integer age;
    private Double price;

    @ManyToOne
    private Client client_id;
}
