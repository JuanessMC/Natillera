package com.natillera.demo.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tipo_cuenta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoCuentaEntity {
    @Id
    @Column(name = "id_tipo_cuenta")
    private long id;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @OneToMany(mappedBy = "tipoCuenta", cascade = CascadeType.ALL)
    private List<CuentaEntity> cuentas;
}
