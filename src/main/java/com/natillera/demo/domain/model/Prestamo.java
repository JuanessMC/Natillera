package com.natillera.demo.domain.model;

import java.time.LocalDate;

public class Prestamo {
    private final Long idPrestamo;
    private final long cedula;
    private final Long valorPrestamo;
    private final float tasaInteres;
    private final int plazoPago;
    private final Long valorMensual;
    private final LocalDate fecha;
    private final String estadoPago;

    public Prestamo(Long idPrestamo, Long valorPrestamo, float tasaInteres, int plazoPago, Long valorMensual, LocalDate fecha, String estadoPago, long cedula) {
        this.idPrestamo = idPrestamo;
        this.valorPrestamo = valorPrestamo;
        this.tasaInteres = tasaInteres;
        this.plazoPago = plazoPago;
        this.valorMensual= valorMensual;
        this.fecha = fecha;
        this.estadoPago = estadoPago;
        this.cedula = cedula;
    }

    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public Long getValorPrestamo() {
        return valorPrestamo;
    }

    public float getTasaInteres() {
        return tasaInteres;
    }

    public int getPlazoPago() {
        return plazoPago;
    }

    public Long getValorMensual() {
        return valorMensual;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public long getCedula() {
        return cedula;
    }
}
