package com.paulo.paulinho.service;

import com.paulo.paulinho.dto.client.ClientMapper;
import com.paulo.paulinho.dto.client.ClientRequest;
import com.paulo.paulinho.dto.client.ClientResponse;
import com.paulo.paulinho.model.Client;
import com.paulo.paulinho.repository.ClientRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientMapper mapper;

    public Client adicionaClient(ClientRequest clientRequest) {
        Client client = mapper.toClient(clientRequest);
        repository.save(client);
        return client;
    }

    public List<Client> listarClient() {
        return repository.findAll();
    }

    public ClientResponse listarPeloId(UUID id) throws BadRequestException {
        return mapper.toClientResponse(repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado")));
    }


}
