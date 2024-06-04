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
    @Mapping(target = "idMulta", source = "idMulta")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "valorMulta", source = "valorMulta")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "cedula", source = "socio.cedula")
    Multa toModel(MultaEntity multaEntity);



}
