package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IPrestamoRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.exception.GeneralException;
import com.natillera.demo.domain.spi.IEstadisticaPersistencePort;
import lombok.RequiredArgsConstructor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class EstadisticaAdapter implements IEstadisticaPersistencePort {
    private final IUsuarioRepository usuarioRepository;

    private final IPrestamoRepository prestamoRepository;

    @Override
    public Map<String, Object> getPorcentajeRecaudado() {
        return calcularPorcentaje(usuarioRepository.getPagosResumen());
    }

    @Override
    public Map<String, Object> getInteresesPorPeriodo() {
        return calcularPorcentaje(usuarioRepository.getInteresesPorPeriodo());
    }

    private Map<String, Object> calcularPorcentaje(List<Map<String, Object>> estadisticas) {
        double total = obtenerTotal(estadisticas);

        List<Map<String, Object>> estadisticasConPorcentaje = new ArrayList<>();
        for (Map<String, Object> item : estadisticas) {
            Map<String, Object> nuevoItem = new HashMap<>();
            nuevoItem.put("name", item.get("name"));
            double value = ((Number) item.get("value")).doubleValue();
            double percentage = (value / total) * 100;
            nuevoItem.put("value", Math.round(percentage * 100.0) / 100.0);
            estadisticasConPorcentaje.add(nuevoItem);
        }

        DecimalFormat df = new DecimalFormat("#.##");

        Map<String, Object> response = new HashMap<>();
        response.put("total", df.format(total));
        response.put("estadisticas", estadisticasConPorcentaje);

        return response;
    }

    private double obtenerTotal(List<Map<String, Object>> estadisticas) {
        if (!estadisticas.isEmpty()) {
            return ((Number) estadisticas.get(0).get("total")).doubleValue();
        }
        return 0;
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
