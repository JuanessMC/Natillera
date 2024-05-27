package com.natillera.demo.adapters.driven.jpa.mysql.mapper;


import com.natillera.demo.adapters.driven.jpa.mysql.entity.SocioEntity;
import com.natillera.demo.domain.model.Socio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISocioEntityMapper {
    @Mapping(target = "salarioMensual", source = "salarioMensual")
    @Mapping(target = "estado", source = "usuario.estado")
    @Mapping(target = "correoElectronico", source = "usuario.correoElectronico")
    @Mapping(target = "fechaNacimiento", source = "usuario.fechaNacimiento")
    @Mapping(target = "apellidos", source = "usuario.apellidos")
    @Mapping(target = "nombre", source = "usuario.nombre")
    @Mapping(target = "cedula", source = "usuario.cedula")
    Socio toModel(SocioEntity socioEntity);

    @Mapping(source = "salarioMensual", target = "salarioMensual")
    @Mapping(source = "cedula", target = "cedula")
    SocioEntity toEntity(Socio socio);
}