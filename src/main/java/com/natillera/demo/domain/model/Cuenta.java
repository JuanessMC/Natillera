package com.natillera.demo.domain.model;

public class Cuenta {
    private final long id;
    private final String nombreBanco;
    private final long numeroCuenta;
    private TipoCuenta tipoCuenta;

    public Cuenta(long id, String nombreBanco, long numeroCuenta) {
        this.id = id;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public long getId() {
        return id;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }
}
