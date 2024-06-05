package com.natillera.demo.adapters.driving.http.controller;
import com.natillera.demo.adapters.driving.http.dto.response.EstadisticaResponse;
import com.natillera.demo.adapters.driving.http.dto.response.StandardResponse;
import com.natillera.demo.domain.api.IEstadisticaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
@RestController
@RequestMapping("/estadisticas")
@RequiredArgsConstructor
public class EstadisticaRestControllerAdapter {

    private final IEstadisticaServicePort estadisticaServicePort;

    @GetMapping("/recaudado")
    public ResponseEntity<StandardResponse<EstadisticaResponse>> getPorcentajeRecaudado() {
        EstadisticaResponse estadistica = new EstadisticaResponse(estadisticaServicePort.getPorcentajeRecaudado());

        StandardResponse<EstadisticaResponse> response = new StandardResponse<>(
                "Ganancias obtenidas correctamente",
                200,
                LocalDateTime.now().toString()
        );
        response.setData(estadistica);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/intereses/periodos")
    public ResponseEntity<StandardResponse<EstadisticaResponse>> getPagosEstadisticas() {
        EstadisticaResponse estadistica = new EstadisticaResponse(estadisticaServicePort.getInteresesPorPeriodo());

        StandardResponse<EstadisticaResponse> response = new StandardResponse<>(
                "Ganancias de intereses obtenida correctamente",
                200,
                LocalDateTime.now().toString()
        );
        response.setData(estadistica);

        return ResponseEntity.ok(response);
    }
}