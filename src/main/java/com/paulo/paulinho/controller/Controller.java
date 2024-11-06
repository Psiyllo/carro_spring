package com.paulo.paulinho.controller;

import com.paulo.paulinho.dto.carro.CarroRequest;
import com.paulo.paulinho.dto.client.ClientRequest;
import com.paulo.paulinho.dto.client.ClientResponse;
import com.paulo.paulinho.model.Carro;
import com.paulo.paulinho.model.Client;
import com.paulo.paulinho.service.CarroService;
import com.paulo.paulinho.service.ClientService;
import org.apache.coyote.BadRequestException;
import org.aspectj.bridge.context.ContextToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1")
public class Controller {

    private ClientService clientService;
    private CarroService carroService;

    @Autowired
    public Controller(ClientService clientService, CarroService carroService) {
        this.clientService = clientService;
        this.carroService = carroService;
    }

    public Controller(CarroService carroService){this.carroService = carroService;}

    public Controller(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client adiciona(@RequestBody ClientRequest request) {
        return clientService.adicionaClient(request);
    }

    @PostMapping("carro")
    @ResponseStatus(HttpStatus.CREATED)
    public Carro adiciona(@RequestBody CarroRequest request){return carroService.adicionaCarro(request);}

    @GetMapping("carro")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Carro> listarCarro(){return carroService.listarCarro();
    }

    @GetMapping("client")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Client> listarClient() {return clientService.listarClient();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ClientResponse achar(@PathVariable UUID id) throws BadRequestException {
        return clientService.listarPeloId(id);
    }

}
