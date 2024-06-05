package com.natillera.demo.domain.api.usecase;

import com.natillera.demo.domain.api.IEstadisticaServicePort;
import com.natillera.demo.domain.spi.IEstadisticaPersistencePort;

import java.util.Map;

public class EstadisticaUseCase implements IEstadisticaServicePort {
    private final IEstadisticaPersistencePort estadisticaPersistencePort;

    public EstadisticaUseCase(IEstadisticaPersistencePort estadisticaPersistencePort) {
        this.estadisticaPersistencePort = estadisticaPersistencePort;
    }

    @Override
    public Map<String, Object> getPorcentajeRecaudado() {
        return estadisticaPersistencePort.getPorcentajeRecaudado();
    }

    @Override
    public Map<String, Object> getInteresesPorPeriodo() {
        return estadisticaPersistencePort.getInteresesPorPeriodo();
    }
}
