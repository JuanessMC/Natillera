package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.TipoCuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITipoCuentaRepository extends JpaRepository<TipoCuentaEntity, Long> {
    Optional<TipoCuentaEntity> findById(long id);
}
