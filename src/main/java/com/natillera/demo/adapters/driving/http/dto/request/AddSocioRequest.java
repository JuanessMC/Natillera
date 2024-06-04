package com.natillera.demo.adapters.driving.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record AddSocioRequest(

        long cedula,
        String nombre,
        String apellidos,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate fechaNacimiento,
        String correoElectronico,
        boolean estado,
        String nombreBanco,
        long numeroCuenta,
        long idTipoCuenta) {
}
