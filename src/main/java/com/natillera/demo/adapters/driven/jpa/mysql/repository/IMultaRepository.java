package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.MultaEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.entity.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IMultaRepository extends JpaRepository<MultaEntity, Integer> {
    MultaEntity findBySocio(SocioEntity socioEntity);

    @Modifying
    @Transactional
    @Query("UPDATE MultaEntity m SET m = :multaEntity WHERE m.idMulta= :idMulta")
    Void updateByIdMulta(@Param("multaEntity") MultaEntity multaEntity, @Param("idMulta") Integer idMulta);
}