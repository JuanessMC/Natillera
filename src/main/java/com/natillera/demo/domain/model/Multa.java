package com.natillera.demo.domain.model;

import java.time.LocalDate;

public class Multa {

  private final Integer idMulta;

  private final String nombre;

  private final Float valorMulta;
  private final String descripcion;

  private final LocalDate fecha;

  private final boolean estado;

  private final long cedula;

    public Multa(Integer idMulta, String nombre, Float valor, String descripcion, LocalDate fecha, boolean estadoPago, long cedula) {
        this.idMulta = idMulta;
        this.nombre = nombre;
        this.valorMulta = valor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estadoPago;
        this.cedula = cedula;
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getValorMulta() {
        return valorMulta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public long getCedula() {
        return cedula;
    }
}
