package com.natillera.demo.adapters.driving.http.dto.request;

import java.time.LocalDate;

public record AddSocioRequest(
        long documento,
        String nombre,

        String apellidos,
        LocalDate fechaNacimiento,
        String correoElectronico,
        boolean estado,
        float salarioMensual) {
}
