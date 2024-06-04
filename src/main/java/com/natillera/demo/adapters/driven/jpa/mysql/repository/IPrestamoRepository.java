package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    PrestamoEntity findByIdPrestamo(long idPrestamo);

    @Modifying
    @Transactional
    @Query("UPDATE PrestamoEntity p SET p.estadoPago = :#{#prestamoEntity.estadoPago}," +
            " p.fecha = :#{#prestamoEntity.fecha}," +
            " p.plazoPago = :#{#prestamoEntity.plazoPago}," +
            "p.valorMensual = :#{#prestamoEntity.valorMensual}," +
            " p.socio.cedula = :#{#prestamoEntity.socio.cedula}," +
            " p.tasaInteres = :#{#prestamoEntity.tasaInteres}," +
            " p.valorPrestamo = :#{#prestamoEntity.valorPrestamo}," +
            " p.observaciones = :#{#prestamoEntity.observaciones}" +
            " WHERE p.idPrestamo = :idPrestamo")
    void updateById(@Param("prestamoEntity") PrestamoEntity prestamoEntity, @Param("idPrestamo") Long idPrestamo);
}
