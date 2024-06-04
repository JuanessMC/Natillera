package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.request.AddPrestamoRequest;
import com.natillera.demo.domain.model.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPrestamoRequestMapper {

    @Mapping(source = "valorPrestamo", target = "valorPrestamo")
    @Mapping(source = "tasaInteres", target = "tasaInteres")
    @Mapping(source = "plazoPago", target = "plazoPago")
    @Mapping(source = "valorMensual", target = "valorMensual")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "cedula", target = "cedula")
    @Mapping(source = "observaciones", target = "observaciones")
    Prestamo addRequestToPrestamo(AddPrestamoRequest prestamo);

    @Mapping(source = "valorPrestamo", target = "valorPrestamo")
    @Mapping(source = "tasaInteres", target = "tasaInteres")
    @Mapping(source = "plazoPago", target = "plazoPago")
    @Mapping(source = "valorMensual", target = "valorMensual")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "cedula", target = "cedula")
    @Mapping(source = "observaciones", target = "observaciones")
    AddPrestamoRequest prestamoToResponse(Prestamo prestamo);
}
