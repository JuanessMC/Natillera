package com.natillera.demo.domain.api.usecase;

import com.natillera.demo.domain.api.IEstadisticaServicePort;
import com.natillera.demo.domain.spi.IEstadisticaPersistencePort;

import java.util.List;
import java.util.Map;

public class EstadisticaUseCase implements IEstadisticaServicePort {
    private final IEstadisticaPersistencePort persistencePort;

    public EstadisticaUseCase(IEstadisticaPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public Map<String, Object> getPagosResumen() {
        return persistencePort.getPagosResumen();
    }
}
