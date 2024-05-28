package com.natillera.demo.domain.model;

public class TipoCuenta {
    private final long id;
    private final String nombre;

    public TipoCuenta(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
