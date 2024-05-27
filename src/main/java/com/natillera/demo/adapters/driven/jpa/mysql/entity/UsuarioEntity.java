package com.natillera.demo.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioEntity {
    @Id
    private Long cedula;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String correoElectronico;
    private boolean estado;
}
