package com.natillera.demo.domain.api;

import java.util.Map;

public interface IEstadisticaServicePort {
    Map<String, Object> getPorcentajeRecaudado();

    Map<String, Object> getInteresesPorPeriodo();

    String getAllPrestamosAprovadosOrPendientes();
}
