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
    public ResponseEntity<StandardResponse<MultaResponse>> addOrUpdateMulta(@RequestBody AddMultaRequest addMultaRequest) {
        String response = multaServicePort.addOrUpdateMulta(multaRequestMapper.addRequestToMulta(addMultaRequest));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new StandardResponse<>(
                        response,
                        200,
                        LocalDateTime.now().toString())
                );
    }

}
