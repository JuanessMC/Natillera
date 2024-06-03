package com.natillera.demo.adapters.driving.http.controller;

import com.natillera.demo.adapters.driving.http.dto.response.PrestamoResponse;
import com.natillera.demo.adapters.driving.http.dto.response.PrestamoResponseList;
import com.natillera.demo.adapters.driving.http.dto.response.StandardResponse;
import com.natillera.demo.adapters.driving.http.mapper.IPrestamoRequestMapper;
import com.natillera.demo.adapters.driving.http.mapper.IPrestamoResponseMapper;
import com.natillera.demo.domain.api.IPrestamoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prestamo")
@RequiredArgsConstructor
public class PrestamoRestControllerAdapter {

    private final IPrestamoServicePort prestamoServicePort;
    private final IPrestamoRequestMapper prestamoRequestMapper;
    private final IPrestamoResponseMapper prestamoResponseMapper;


    @GetMapping("/")
    public ResponseEntity<StandardResponse<PrestamoResponse>> getPrestamo(@RequestParam long id) {
        PrestamoResponse prestamoResponse = prestamoResponseMapper
                .addRequestToPrestamo(prestamoServicePort.getPrestamoById(id));

        StandardResponse<PrestamoResponse> response = new StandardResponse<>(
                "",
                200,
                LocalDateTime.now().toString()
        );
        response.setData(prestamoResponse);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all/")
    public ResponseEntity<StandardResponse<PrestamoResponseList>> getAllPrestamo() {

        PrestamoResponseList prestamoResponseList = new PrestamoResponseList();

        prestamoResponseList.setResponseList(prestamoResponseMapper
                .addRequestToPrestamoList(prestamoServicePort.getAllPrestamos()));

        StandardResponse<PrestamoResponseList> response = new StandardResponse<>(
                "",
                200,
                LocalDateTime.now().toString()
        );

        response.setData(prestamoResponseList);

        return ResponseEntity.ok(response);
    }

    //metodo que actualiza el prestamo
    @PostMapping("/")
    public ResponseEntity<StandardResponse<PrestamoResponse>> updatePrestamo(@RequestParam long id) {

        PrestamoResponse prestamoResponse = prestamoResponseMapper
                .addRequestToPrestamo(prestamoServicePort.getPrestamoById(id));

        StandardResponse<PrestamoResponse> response = new StandardResponse<>(
                "",
                200,
                LocalDateTime.now().toString()
        );
        response.setData(prestamoResponse);

        return ResponseEntity.ok(response);
    }

}
