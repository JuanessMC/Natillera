package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    PrestamoEntity findByIdPrestamo(long cedula);

//    @Modifying
//    @Transactional
//    @Query("UPDATE PrestamoEntity p SET p = :prestamoEntity WHERE p.idPrestamo = :idPrestamo")
//    void updateById(@Param("prestamoEntity") PrestamoEntity prestamoEntity, @Param("idPrestamo") long idPrestamo);
//
//}

    @Modifying
    @Transactional
    @Query("UPDATE PrestamoEntity p SET p.estadoPago = :#{#prestamoEntity.estadoPago}, p.fecha = :#{#prestamoEntity.fecha}, p.plazoPago = :#{#prestamoEntity.plazoPago}, p.socio.cedula = :#{#prestamoEntity.socio.cedula}, p.tasaInteres = :#{#prestamoEntity.tasaInteres}, p.valorPrestamo = :#{#prestamoEntity.valorPrestamo} WHERE p.idPrestamo = :idPrestamo")
    void updateById(@Param("prestamoEntity") PrestamoEntity prestamoEntity, @Param("idPrestamo") long idPrestamo);
}
