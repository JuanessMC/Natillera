package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.request.AddSocioRequest;
import com.natillera.demo.domain.model.Socio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISocioRequestMapper {
    @Mapping(source = "idTipoCuenta", target = "cuenta.tipoCuenta.id")
    @Mapping(source = "numeroCuenta", target = "cuenta.numeroCuenta")
    @Mapping(source = "nombreBanco", target = "cuenta.nombreBanco")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "correoElectronico", target = "correoElectronico")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "apellidos", target = "apellidos")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "cedula", target = "cedula")
    Socio addRequestToUsuario(AddSocioRequest addSocioRequest);
}
