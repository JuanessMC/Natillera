package com.natillera.demo.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private String id;

    @Column(name = "nombre_banco")
    private String nombreBanco;

    @Column(name = "numero_cuenta")
    private long numeroCuenta;

    @OneToOne
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta")
    private TipoCuentaEntity tipoCuenta;
}