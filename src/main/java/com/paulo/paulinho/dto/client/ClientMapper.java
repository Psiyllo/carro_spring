package com.paulo.paulinho.dto.client;

import com.paulo.paulinho.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "clientMapperImpl")
public interface ClientMapper {

    Client toClient(ClientRequest request);

    ClientResponse toClientResponse(Client client);
}
