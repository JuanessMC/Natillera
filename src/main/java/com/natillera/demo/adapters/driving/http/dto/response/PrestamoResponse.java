package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PrestamoResponse {
    private final Long idPrestamo;
    private final Long valorPrestamo;
    private final float tasaInteres;
    private final int plazoPago;
    private final String fecha;
    private final String estadoPago;
    private final String cedula;
}
