package com.natillera.demo.adapters.driven.jpa.mysql.mapper;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import com.natillera.demo.domain.model.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPrestamoMapper {

    @Mapping(source = "valorPrestamo", target = "valorPrestamo")
    @Mapping(source = "tasaInteres", target = "tasaInteres")
    @Mapping(source = "plazoPago", target = "plazoPago")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "cedula", target = "socio.cedula")
    PrestamoEntity toEntity(Prestamo prestamo);

    @Mapping(source = "valorPrestamo", target = "valorPrestamo")
    @Mapping(source = "tasaInteres", target = "tasaInteres")
    @Mapping(source = "plazoPago", target = "plazoPago")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "socio.cedula", target = "cedula")
    Prestamo toModel(PrestamoEntity prestamoEntity);

}
