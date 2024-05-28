package com.natillera.demo.adapters.driving.http.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record AddSocioRequest(

        long cedula,
        String nombre,

        String apellidos,
        LocalDate fechaNacimiento,
        String correoElectronico,
        boolean estado,
        float salarioMensual) {
}
