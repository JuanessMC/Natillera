package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.response.PrestamoResponse;
import com.natillera.demo.domain.model.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPrestamoResponseMapper {

    @Mapping(source = "valorPrestamo", target = "valorPrestamo")
    @Mapping(source = "tasaInteres", target = "tasaInteres")
    @Mapping(source = "plazoPago", target = "plazoPago")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "cedula", target = "cedula")
    PrestamoResponse addRequestToPrestamo(Prestamo prestamo);

    List<PrestamoResponse> addRequestToPrestamoList(List<Prestamo> prestamo);
}
