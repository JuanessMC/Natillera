package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class PrestamoResponse {
    private Long idPrestamo;
    private Long valorPrestamo;
    private float tasaInteres;
    private int plazoPago;
    private Long valorMensual;
    private String fecha;
    private String estadoPago;
    private String cedula;
    private String observaciones;
    private String nombre;
    private String apellido;
}
