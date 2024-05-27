package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class SocioResponse {
    private final long documento;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private final String correoElectronico;
    private final boolean estado;
    private final float salarioMensual;
}
