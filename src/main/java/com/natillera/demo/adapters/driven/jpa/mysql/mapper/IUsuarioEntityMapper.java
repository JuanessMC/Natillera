package com.natillera.demo.adapters.driven.jpa.mysql.mapper;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import com.natillera.demo.domain.model.Socio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface IUsuarioEntityMapper {

    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "correoElectronico", target = "correoElectronico")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "apellidos", target = "apellidos")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "cedula", target = "cedula")
    @Mapping(source = "cedula", target = "socio.cedula")
    @Mapping(source = "salarioMensual", target = "socio.salarioMensual")
    UsuarioEntity toEntity(Socio socio);
}
