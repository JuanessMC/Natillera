package com.natillera.demo.domain.model;

import java.time.LocalDate;

public class Multa {

  private final Integer idMulta;

  private final String nombre;

  private final float valorMulta;
  private final String descripcion;

  private final LocalDate fecha;

  private final boolean estado;

  private final Long cedula;

    public Multa(Integer idMulta, String nombre, float valorMulta, String descripcion, LocalDate fecha, boolean estado, Long cedula) {
        this.idMulta = idMulta;
        this.nombre = nombre;
        this.valorMulta = valorMulta;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.cedula = cedula;
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public String getNombre() {
        return nombre;
    }

    public float getValorMulta() {
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

    public Long getCedula() {
        return cedula;
    }
}
