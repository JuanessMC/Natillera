package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    PrestamoEntity findBySocioCedula(long cedula);
    @Modifying
    @Transactional
    @Query("UPDATE PrestamoEntity p SET p = :PrestamoEntity WHERE p.socio.cedula = :cedula")
    void updateByCedula(@Param("prestamoEntity") PrestamoEntity prestamoEntity, @Param("cedula") long cedula);
}
