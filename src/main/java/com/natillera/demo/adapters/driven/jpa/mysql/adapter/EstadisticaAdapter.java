package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IPrestamoRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.exception.GeneralException;
import com.natillera.demo.domain.spi.IEstadisticaPersistencePort;
import lombok.RequiredArgsConstructor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class EstadisticaAdapter implements IEstadisticaPersistencePort {
    private final IUsuarioRepository usuarioRepository;

    private final IPrestamoRepository prestamoRepository;

    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");


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

        Map<String, Object> response = new HashMap<>();
        response.put("total", decimalFormat.format(total));
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
    public String getAllPrestamosAprovadosOrPendientes() {
        try {
            final List<PrestamoEntity> prestamos = prestamoRepository.getAllPrestamosAprovadosOrPendientes();
            final double sum = prestamos.stream()
                    .mapToDouble(PrestamoEntity::getValorPrestamo)
                    .sum();
            return decimalFormat.format(sum);
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    @Override
    public Map<String, Object> getDineroRecaudado() {

        final Double totalAportes = usuarioRepository.getTotalAportes();
        final Double totalInteresesPagados = usuarioRepository.getTotalInteresesPagados();
        final Double totalMultas = usuarioRepository.getTotalMultas();
        final Double totalActividades = usuarioRepository.getTotalActividades();

        List<Map<String, Object>> estadisticas = Arrays.asList(
                createStatistic("multas", totalMultas),
                createStatistic("aportes", totalAportes),
                createStatistic("actividades", totalActividades),
                createStatistic("intereses", totalInteresesPagados)
        );

        Map<String, Object> data = new HashMap<>();
        data.put("estadisticas", estadisticas);

        return data;
    }

    private Map<String, Object> createStatistic(String name, Double value) {
        Map<String, Object> statistic = new HashMap<>();
        statistic.put("name", name);
        statistic.put("value", decimalFormat.format(value));
        return statistic;
    }
}
