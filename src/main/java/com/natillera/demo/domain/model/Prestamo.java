package com.natillera.demo.domain.model;

import java.util.Date;

public class Prestamo {
    private final Long idPrestamo;
    private final Long valorPrestamo;
    private final float tasaInteres;
    private final int plazoPago;
    private final Date fecha;
    private final String estadoPago;
    private final String cedula;

    public Prestamo(Long idPrestamo, Long valorPrestamo, float tasaInteres, int plazoPago, Date fecha, String estadoPago, String cedula) {
        this.idPrestamo = idPrestamo;
        this.valorPrestamo = valorPrestamo;
        this.tasaInteres = tasaInteres;
        this.plazoPago = plazoPago;
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

    public Date getFecha() {
        return fecha;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public String getCedula() {
        return cedula;
    }
}
