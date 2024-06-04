package com.natillera.demo.adapters.driving.http.dto.request;

import java.time.LocalDate;

public record AddMultaRequest(
        Integer idMulta,
        String nombre,
        float valorMulta,
        String descripcion,
        LocalDate fecha,
        boolean estado,
        long cedula
) {

}
