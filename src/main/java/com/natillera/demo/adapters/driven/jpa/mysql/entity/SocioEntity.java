package com.natillera.demo.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
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

    @OneToMany(mappedBy = "socio")
    private List<PrestamoEntity> prestamos;

}