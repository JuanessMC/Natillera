package com.natillera.demo.domain.model;

import java.time.LocalDate;

public abstract class Usuario {
    private final long documento;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private final String correoElectronico;
    private final boolean estado;

    public Usuario(long documento, String nombre, String apellidos, LocalDate fechaNacimiento, String correoElectronico, boolean estado) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
    }

    public long getDocumento() {
        return documento;
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
