package com.natillera.demo.domain.spi;

import java.util.Map;

public interface IEstadisticaPersistencePort {
    Map<String, Object> getPorcentajeRecaudado();

    Map<String, Object> getInteresesPorPeriodo();

    String getAllPrestamosAprovadosOrPendientes();

}
