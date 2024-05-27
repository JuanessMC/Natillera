package com.natillera.demo.adapters.driving.http.controller;

import com.natillera.demo.adapters.driving.http.dto.request.AddSocioRequest;
import com.natillera.demo.adapters.driving.http.mapper.ISocioRequestMapper;
import com.natillera.demo.domain.api.ISocioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socio")
@RequiredArgsConstructor
public class SocioRestControllerAdapter {
    private final ISocioServicePort socioServicePort;
    private final ISocioRequestMapper socioRequestMapper;
    @PostMapping("/")
    public ResponseEntity<String>addSocio(@RequestBody AddSocioRequest addSocioRequest)
    {
        socioServicePort.addSocio(socioRequestMapper.addRequestToUsuario(addSocioRequest));
        return ResponseEntity.ok("The socio has been successfully recorded");
    }
}
