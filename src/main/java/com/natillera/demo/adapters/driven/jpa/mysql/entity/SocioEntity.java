package com.natillera.demo.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "socio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocioEntity {
    @Id
    @Column(name = "cedula")
    private Long cedula;

    @Column(name = "salario_mensual")
    private float salarioMensual;

    @OneToOne
    @JoinColumn(name = "cedula")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "socio")
    private Set<MultaEntity> multas;
}