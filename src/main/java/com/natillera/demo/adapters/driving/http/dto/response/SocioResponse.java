package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SocioResponse {
    private final long cedula;
    private final String nombre;
    private final String apellidos;
    private final String fechaNacimiento;
    private final String correoElectronico;
    private final boolean estado;
    private final float salarioMensual;
    private final String nombreBanco;
    private final long numeroCuenta;
    private final long idTipoCuenta;
}
