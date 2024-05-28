package com.natillera.demo.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cuenta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuentaEntity {

    @Id
    @Column(name = "id_cuenta")
    private String id;

    @Column(name = "nombre_banco")
    private String nombreBanco;

    @Column(name = "nombre_cuenta")
    private String nombreCuenta;

    @OneToOne
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta")
    private TipoCuentaEntity tipoCuenta;
}