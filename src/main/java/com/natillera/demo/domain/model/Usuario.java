package com.natillera.demo.domain.model;

import java.time.LocalDate;

public abstract class Usuario {
    private final long cedula;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private final String correoElectronico;
    private final boolean estado;

    protected Usuario(long cedula, String nombre, String apellidos, LocalDate fechaNacimiento, String correoElectronico, boolean estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
    }

    public long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public boolean isEstado() {
        return estado;
    }
}
