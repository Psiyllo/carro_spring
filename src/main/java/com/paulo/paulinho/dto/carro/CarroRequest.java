package com.paulo.paulinho.dto.carro;

import java.util.UUID;

public record CarroRequest(String model, Integer age, Double price, UUID clientId) {
}
