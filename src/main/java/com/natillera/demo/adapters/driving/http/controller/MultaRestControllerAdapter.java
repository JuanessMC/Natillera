package com.natillera.demo.adapters.driving.http.controller;

import com.natillera.demo.adapters.driving.http.dto.request.AddMultaRequest;
import com.natillera.demo.adapters.driving.http.dto.response.MultaResponse;
import com.natillera.demo.adapters.driving.http.dto.response.StandardResponse;
import com.natillera.demo.adapters.driving.http.mapper.IMultaRequestMapper;
import com.natillera.demo.domain.api.IMultaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/multa")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class MultaRestControllerAdapter {

    private final IMultaServicePort multaServicePort;
    private final IMultaRequestMapper multaRequestMapper;

    @PostMapping("/")
    public ResponseEntity<StandardResponse<MultaResponse>> saveMulta(@RequestBody AddMultaRequest addMultaRequest) {
        Object[] response = multaServicePort.saveMulta(multaRequestMapper.addRequestToMulta(addMultaRequest));
        int statusCode = (int) response[0];
        String message = (String) response[1];
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new StandardResponse<>(
                        message,
                        statusCode,
                        LocalDateTime.now().toString())
                );
    }
}
