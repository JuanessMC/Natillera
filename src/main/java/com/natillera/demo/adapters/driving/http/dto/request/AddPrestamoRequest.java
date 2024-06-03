package com.natillera.demo.adapters.driving.http.dto.request;

public record AddPrestamoRequest (
        long idPrestamo,
        long valorPrestamo,
        float tasaInteres,
        int plazoPago,
        String fecha,
        String estadoPago,
        long cedula){

}
