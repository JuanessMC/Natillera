package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PrestamoResponse {
    private final Long idPrestamo;
    private final Long valorPrestamo;
    private final float tasaInteres;
    private final int plazoPago;
    private final Date fecha;
    private final String estadoPago;
    private final String cedula;
}
