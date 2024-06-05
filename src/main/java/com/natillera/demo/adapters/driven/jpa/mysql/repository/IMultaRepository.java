package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.MultaEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.entity.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMultaRepository extends JpaRepository<MultaEntity, Integer> {
    MultaEntity findBySocio(SocioEntity socioEntity);
}