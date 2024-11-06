package com.paulo.paulinho.service;

import com.paulo.paulinho.dto.carro.CarroMapper;
import com.paulo.paulinho.dto.carro.CarroRequest;
import com.paulo.paulinho.model.Carro;
import com.paulo.paulinho.model.Client;
import com.paulo.paulinho.repository.CarroRepository;
import com.paulo.paulinho.repository.ClientRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarroMapper carroMapper;

    public Carro adicionaCarro(CarroRequest carroRequest){
        Carro carro = carroMapper.toCarro(carroRequest);
        UUID clientId = carroRequest.clientId();
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        carro.setClient_id(client);

        carroRepository.save(carro);
        return carro;
    }
    public List<Carro> listarCarro(){return carroRepository.findAll();}
}
