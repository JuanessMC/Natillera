package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
}
