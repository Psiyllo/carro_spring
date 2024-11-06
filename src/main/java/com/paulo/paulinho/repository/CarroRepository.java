package com.paulo.paulinho.repository;

import com.paulo.paulinho.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarroRepository extends JpaRepository<Carro, UUID> {
}
