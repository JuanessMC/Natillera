package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
@RequiredArgsConstructor
@Getter
public class EstadisticaResponse {
    private final Map<String, Object> resultado;
}
