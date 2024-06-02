package com.natillera.demo.adapters.driving.http.controller;

import com.natillera.demo.adapters.driving.http.dto.request.AddSocioRequest;
import com.natillera.demo.adapters.driving.http.dto.response.SocioResponse;
import com.natillera.demo.adapters.driving.http.dto.response.StandardResponse;
import com.natillera.demo.adapters.driving.http.mapper.ISocioRequestMapper;
import com.natillera.demo.adapters.driving.http.mapper.ISocioResponseMapper;
import com.natillera.demo.domain.api.ISocioServicePort;
import com.natillera.demo.domain.model.Socio;
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
    public ResponseEntity<String> addSocio(@RequestBody AddSocioRequest addSocioRequest)
    {
        socioServicePort.addSocio(socioRequestMapper.addRequestToUsuario(addSocioRequest));
        return ResponseEntity.ok("The socio has been successfully recorded");
    }

    @GetMapping("/")
    public ResponseEntity<SocioResponse> getSocio(@RequestParam long id)
    {
        return ResponseEntity.ok(socioResponseMapper.addRequestToUsuario(socioServicePort.getSocio(id)));
    }
}
//The request handler function in a Controller should set the appropriate HTTP status code based on the operation’s success or failure. This is done by returning a Response object with the appropriate status code.
//If an exception is thrown during the execution of the handler, the status code should be in the range of 4xx or 5xx. Examples of such codes are BAD_REQUEST, UNAUTHORIZED, FORBIDDEN, NOT_FOUND, INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE, etc.
//The status code should be 1xx, 2xx, or 3xx if no exception is thrown and the operation is considered successful. Such codes include OK, CREATED, MOVED_PERMANENTLY, FOUND, etc.