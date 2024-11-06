package com.paulo.paulinho.dto.carro;

import com.paulo.paulinho.model.Carro;
import com.paulo.paulinho.repository.CarroRepository;
import org.mapstruct.Mapper;

import java.awt.*;

@Mapper(componentModel = "spring", implementationName = "carroMapperImpl" )
public interface CarroMapper {

    Carro toCarro(CarroRequest carroRequest);

    CarroResponse toCarroResponse(Carro carro);

}
