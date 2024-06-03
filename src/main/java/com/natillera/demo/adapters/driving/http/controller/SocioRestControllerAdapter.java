package com.natillera.demo.adapters.driving.http.controller;

import com.natillera.demo.adapters.driving.http.dto.request.AddSocioRequest;
import com.natillera.demo.adapters.driving.http.dto.response.SocioResponse;
import com.natillera.demo.adapters.driving.http.dto.response.SocioResponseList;
import com.natillera.demo.adapters.driving.http.dto.response.StandardResponse;
import com.natillera.demo.adapters.driving.http.mapper.ISocioRequestMapper;
import com.natillera.demo.adapters.driving.http.mapper.ISocioResponseMapper;
import com.natillera.demo.domain.api.ISocioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/socio")
@RequiredArgsConstructor
public class SocioRestControllerAdapter {
    private final ISocioServicePort socioServicePort;
    private final ISocioRequestMapper socioRequestMapper;
    private final ISocioResponseMapper socioResponseMapper;
    @PostMapping("/")
    public ResponseEntity<StandardResponse<SocioResponse>> addSocio(@RequestBody AddSocioRequest addSocioRequest)
    {
        socioServicePort.addSocio(socioRequestMapper.addRequestToUsuario(addSocioRequest));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new StandardResponse<>(
                        "The socio has been successfully recorded",
                        201,
                        LocalDateTime.now().toString())
                );
    }

    @GetMapping("/")
    public ResponseEntity<StandardResponse<SocioResponse>> getSocio(@RequestParam long id)
    {
        SocioResponse socioResponse = socioResponseMapper.addRequestToUsuario(socioServicePort.getSocio(id));
        StandardResponse<SocioResponse> response = new StandardResponse<>(
                "",
                200,
                LocalDateTime.now().toString()
        );
        response.setData(socioResponse);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all/")
    public ResponseEntity<StandardResponse<SocioResponseList>> getAllSocio()
    {
        SocioResponseList socioResponseList = new SocioResponseList();
        socioResponseList.setResponseList(socioResponseMapper.addRequestToUsuarioList(socioServicePort.getAllSocio()));

        StandardResponse<SocioResponseList> response = new StandardResponse<>(
                "",
                200,
                LocalDateTime.now().toString()
        );
        response.setData(socioResponseList);

        return ResponseEntity.ok(response);
    }
}