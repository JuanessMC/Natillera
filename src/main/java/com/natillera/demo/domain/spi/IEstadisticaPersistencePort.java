package com.natillera.demo.domain.spi;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import com.natillera.demo.domain.model.Prestamo;

import java.util.List;
import java.util.Map;

public interface IEstadisticaPersistencePort {
    Map<String, Object> getPagosResumen();

    Double getAllPrestamosAprovadosOrPendientes();
}
