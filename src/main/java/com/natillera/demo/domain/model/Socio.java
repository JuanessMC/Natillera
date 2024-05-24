package com.natillera.demo.domain.model;

import java.time.LocalDate;

public class Socio extends Usuario{
    private final float salarioMensual;

    public Socio(long documento, String nombre, String apellidos, LocalDate fechaNacimiento, String correoElectronico, boolean estado, float salarioMensual) {
        super(documento, nombre, apellidos, fechaNacimiento, correoElectronico, estado);
        this.salarioMensual = salarioMensual;
    }

    public float getSalarioMensual() {
        return salarioMensual;
    }
}
