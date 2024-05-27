package com.natillera.demo.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "socio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SocioEntity {
    @Id
    private Long cedula;
    private float salarioMensual;

    @OneToOne
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private UsuarioEntity usuario;
}