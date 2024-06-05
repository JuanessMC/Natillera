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
        List<Map<String, Object>> estadisticas = usuarioRepository.getPagosResumen();
        return calcularPorcentaje(estadisticas);
    }

    @Override
    public Map<String, Object> getInteresesPorPeriodo() {
        List<Map<String, Object>> estadisticas = usuarioRepository.getInteresesPorPeriodo();
        return calcularPorcentaje(estadisticas);
    }

    @Override
    public String getAllPrestamosAprovadosOrPendientes() {
        try {
            List<PrestamoEntity> prestamos = prestamoRepository.getAllPrestamosAprovadosOrPendientes();
            double sum = prestamos.stream()
                    .mapToDouble(PrestamoEntity::getValorPrestamo)
                    .sum();
            return decimalFormat.format(sum);
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    @Override
    public Map<String, Object> getGananciasPorNombre() {
        try {
            List<Object[]> estadisticas = usuarioRepository.getGananciasByNombre();
            return calcularGananciasPorNombre(estadisticas);
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    private Map<String, Object> calcularPorcentaje(List<Map<String, Object>> estadisticas) {
        double total = obtenerTotal(estadisticas);

            if(total == 0)
            {
                throw new GeneralException("Error al calcular porcentaje");
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

    private Map<String, Object> calcularGananciasPorNombre(List<Object[]> estadisticas) {
        double total = calcularTotalGanancias(estadisticas, 0);
        List<Map<String, Object>> estadisticasConPorcentaje = calcularEstadisticasConPorcentaje(estadisticas, new ArrayList<>());

        Map<String, Object> response = new HashMap<>();
        response.put("total", decimalFormat.format(total));
        response.put("estadisticas", estadisticasConPorcentaje);

        return response;
    }

    private double calcularTotalGanancias(List<Object[]> estadisticas, int index) {
        if (index >= estadisticas.size()) {
            return 0.0;
        }
        double valor = ((Number) estadisticas.get(index)[1]).doubleValue();
        return valor + calcularTotalGanancias(estadisticas, index + 1);
    }

    private List<Map<String, Object>> calcularEstadisticasConPorcentaje(List<Object[]> estadisticas, List<Map<String, Object>> estadisticasConPorcentaje) {
        return calcularEstadisticasRecursivamente(estadisticas, 0, estadisticasConPorcentaje);
    }

    private List<Map<String, Object>> calcularEstadisticasRecursivamente(List<Object[]> estadisticas, int index, List<Map<String, Object>> estadisticasConPorcentaje) {
        if (index >= estadisticas.size()) {
            return estadisticasConPorcentaje;
        }
        Object[] item = estadisticas.get(index);
        String nombre = (String) item[0];
        double valor = ((Number) item[1]).doubleValue();

        Map<String, Object> estadistica = new HashMap<>();
        estadistica.put("name", nombre);
        estadistica.put("value", valor);
        estadisticasConPorcentaje.add(estadistica);

        return calcularEstadisticasRecursivamente(estadisticas, index + 1, estadisticasConPorcentaje);
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

