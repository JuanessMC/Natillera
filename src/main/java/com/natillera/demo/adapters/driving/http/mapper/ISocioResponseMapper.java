package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.request.AddSocioRequest;
import com.natillera.demo.adapters.driving.http.dto.response.SocioResponse;
import com.natillera.demo.domain.model.Socio;

public interface ISocioResponseMapper {
    SocioResponse addRequestToUsuario(Socio socio);
}
