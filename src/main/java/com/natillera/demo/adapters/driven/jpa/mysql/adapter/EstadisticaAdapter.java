package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IPrestamoRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.exception.GeneralException;
import com.natillera.demo.domain.model.Prestamo;
import com.natillera.demo.domain.spi.IEstadisticaPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class EstadisticaAdapter implements IEstadisticaPersistencePort {
    private final IUsuarioRepository usuarioRepository;

    private final IPrestamoRepository prestamoRepository;
    @Override
    public Map<String, Object> getPagosResumen() {
        List<Map<String, Object>> estadisticas = usuarioRepository.getPagosResumen();
        double total = 1;
        if (!estadisticas.isEmpty()) {
            total = ((Number) estadisticas.get(0).get("total")).doubleValue();
        }

        List<Map<String, Object>> estadisticasConPorcentaje = new ArrayList<>();
        for (Map<String, Object> item : estadisticas) {
            Map<String, Object> nuevoItem = new HashMap<>();
            nuevoItem.put("name", item.get("name"));
            double value = ((Number) item.get("value")).doubleValue();
            double percentage = (value / total) * 100;
            nuevoItem.put("value", Math.round(percentage * 100.0) / 100.0);
            estadisticasConPorcentaje.add(nuevoItem);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("total", total);
        response.put("estadisticas", estadisticasConPorcentaje);

        return response;
    }

    @Override
    public Double getAllPrestamosAprovadosOrPendientes() {
        try {
            final List<PrestamoEntity> prestamos = prestamoRepository.getAllPrestamosAprovadosOrPendientes();
            return prestamos.stream()
                    .mapToDouble(PrestamoEntity::getValorPrestamo)
                    .sum();
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

}
