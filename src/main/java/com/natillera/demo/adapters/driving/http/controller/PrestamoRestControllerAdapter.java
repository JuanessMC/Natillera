package com.natillera.demo.adapters.driving.http.controller;

import com.natillera.demo.adapters.driving.http.dto.request.AddPrestamoRequest;
import com.natillera.demo.adapters.driving.http.dto.response.PrestamoResponse;
import com.natillera.demo.adapters.driving.http.dto.response.PrestamoResponseList;
import com.natillera.demo.adapters.driving.http.dto.response.StandardResponse;
import com.natillera.demo.adapters.driving.http.mapper.IPrestamoRequestMapper;
import com.natillera.demo.adapters.driving.http.mapper.IPrestamoResponseMapper;
import com.natillera.demo.adapters.driving.http.mapper.IUtilities;
import com.natillera.demo.domain.api.IPrestamoServicePort;
import com.natillera.demo.domain.model.Prestamo;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private final ISocioPersistencePort socioPersistencePort;
    private final IUtilities utilities;


    @GetMapping("/")
    public ResponseEntity<StandardResponse<PrestamoResponse>> getPrestamo(@RequestParam long id) {
        Prestamo prestamo = prestamoServicePort.getPrestamoById(id);

        final Socio socio = socioPersistencePort.getSocio(prestamo.getCedula());

        PrestamoResponse prestamoResponse = prestamoResponseMapper
                .addRequestToPrestamo(prestamo);

        prestamoResponse.setNombre(socio.getNombre());
        prestamoResponse.setApellido(socio.getApellidos());

        StandardResponse<PrestamoResponse> response = new StandardResponse<>(
                "Prestamo obtenido correctamente",
                200,
                LocalDateTime.now().toString()
        );
        response.setData(prestamoResponse);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse<PrestamoResponseList>> getAllPrestamo() {

        PrestamoResponseList prestamoResponseList = new PrestamoResponseList();

        prestamoResponseList.setResponseList(prestamoResponseMapper
                .addRequestToPrestamoList(prestamoServicePort.getAllPrestamos()));

        prestamoResponseList = utilities.addNameToPrestamoResponseList(prestamoResponseList);

        StandardResponse<PrestamoResponseList> response = new StandardResponse<>(
                "Prestamos obtenidos correctamente",
                200,
                LocalDateTime.now().toString()
        );

        response.setData(prestamoResponseList);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse<PrestamoResponse>> updatePrestamo(@RequestBody AddPrestamoRequest addPrestamoRequest) {

        prestamoServicePort.updatePrestamo(prestamoRequestMapper.addRequestToPrestamo(addPrestamoRequest));
        return ResponseEntity.ok(new StandardResponse<>(
                "El prestamo fue actualizado satisfactoriamente",
                200,
                LocalDateTime.now().toString())
        );
    }

}
