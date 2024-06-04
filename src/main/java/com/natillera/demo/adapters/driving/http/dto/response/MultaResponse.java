package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class MultaResponse {
    private final Integer idMulta;
    private final String nombre;
    private final Float valor;
    private final String descripcion;
    private final LocalDate fecha;
    private final boolean estadoPago;
    private final long cedula;
}
