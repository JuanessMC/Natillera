package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.response.SocioResponse;
import com.natillera.demo.domain.model.Socio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISocioResponseMapper {
    @Mapping(target = "idTipoCuenta", source = "cuenta.tipoCuenta.id")
    @Mapping(target = "numerodecuenta", source = "cuenta.numeroCuenta")
    @Mapping(target = "banco", source = "cuenta.nombreBanco")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "correo", source = "correoElectronico")
    @Mapping(target = "fecha", source = "fechaNacimiento")
    @Mapping(target = "apellidos", source = "apellidos")
    @Mapping(target = "nombres", source = "nombre")
    @Mapping(target = "cedula", source = "cedula")
    @Mapping(target = "tipodecuenta", source = "cuenta.tipoCuenta.nombre")
    SocioResponse addRequestToUsuario(Socio socio);
    List<SocioResponse> addRequestToUsuarioList(List<Socio> socio);
}
