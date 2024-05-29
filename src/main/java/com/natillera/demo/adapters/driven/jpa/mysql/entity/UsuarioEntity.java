package com.natillera.demo.adapters.driven.jpa.mysql.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioEntity {
    @Id
    @Column(name = "cedula")
    private Long cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "estado")
    private boolean estado;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private SocioEntity socio;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private CuentaEntity cuenta;
}