package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISocioRepository extends JpaRepository<SocioEntity, Long> {
}
