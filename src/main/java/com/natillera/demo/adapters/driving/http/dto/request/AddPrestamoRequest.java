package com.natillera.demo.adapters.driving.http.dto.request;

public record AddPrestamoRequest (
        long idPrestamo,
        long valorPrestamo,
        float tasaInteres,
        int plazoPago,
        Long valorMensual,
        String fecha,
        String estadoPago,
        Long cedula,
        String observaciones){

}
