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
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long idPrestamo;

    @Column(name = "valor_prestamo")
    private Long valorPrestamo;

    @Column(name = "tasa_interes")
    private float tasaInteres;

    @Column(name = "plazo_pago")
    private int plazoPago;

    @Column(name = "valor_mensual")
    private Long valorMensual;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado_pago")
    private String estadoPago;

    @ManyToOne
    @JoinColumn(name = "cedula")
    private SocioEntity socio;

    @Column(name = "observaciones")
    private String observaciones;
}
