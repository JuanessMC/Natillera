package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.response.SocioResponse;
import com.natillera.demo.domain.model.Socio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISocioResponseMapper {
    @Mapping(target = "idTipoCuenta", source = "cuenta.tipoCuenta.id")
    @Mapping(target = "numeroCuenta", source = "cuenta.numeroCuenta")
    @Mapping(target = "nombreBanco", source = "cuenta.nombreBanco")
    @Mapping(target = "salarioMensual", source = "salarioMensual")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "correoElectronico", source = "correoElectronico")
    @Mapping(target = "fechaNacimiento", source = "fechaNacimiento")
    @Mapping(target = "apellidos", source = "apellidos")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "cedula", source = "cedula")
    SocioResponse addRequestToUsuario(Socio socio);
    List<SocioResponse> addRequestToUsuarioList(List<Socio> socio);
}
