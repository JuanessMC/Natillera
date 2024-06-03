package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SocioResponse {
    private final long cedula;
    private final String nombres;
    private final String apellidos;
    private final String fecha;
    private final String correo;
    private final boolean estado;
    private final String banco;
    private final long numerodecuenta;
    private final long idTipoCuenta;
    private final String tipodecuenta;
}
