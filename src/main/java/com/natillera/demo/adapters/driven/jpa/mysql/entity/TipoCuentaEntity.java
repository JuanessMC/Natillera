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
import javax.persistence.Table;

@Entity
@Table(name = "tipo_cuenta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoCuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cuenta")
    private long id;

    @Column(name = "tipo_cuenta")
    private String nombre;
}
