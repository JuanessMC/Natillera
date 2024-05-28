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
    @Mapping(source = "cuenta.nombreBanco", target = "cuenta.nombreBanco")
    @Mapping(source = "cuenta.numeroCuenta", target = "cuenta.numeroCuenta")
    @Mapping(source = "cuenta.tipoCuenta.id", target = "cuenta.tipoCuenta.id")
    @Mapping(source = "cedula", target = "cuenta.usuario.cedula")
    UsuarioEntity toEntity(Socio socio);
}
