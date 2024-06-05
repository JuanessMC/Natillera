package com.natillera.demo.adapters.driven.jpa.mysql.mapper;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.MultaEntity;
import com.natillera.demo.domain.model.Multa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IMultaEntityMapper {

    @Mapping(source = "idMulta", target = "idMulta")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "valorMulta", target = "valorMulta")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "cedula", target = "socio.cedula")
    MultaEntity toEntity(Multa multa);

}
