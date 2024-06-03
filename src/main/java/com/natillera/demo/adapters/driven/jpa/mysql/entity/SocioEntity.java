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
    List<PrestamoEntity> prestamos;

}