package com.natillera.demo.adapters.driven.jpa.mysql.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actividad")
public class ActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private int idActividad;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_realizacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;

    @Column(name = "ubicacion", nullable = false, length = 50)
    private String ubicacion;

    @Column(name = "ganancias", nullable = false)
    private float ganancias;
}