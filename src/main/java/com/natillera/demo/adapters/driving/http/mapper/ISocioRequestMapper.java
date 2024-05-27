package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.request.AddSocioRequest;
import com.natillera.demo.domain.model.Socio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISocioRequestMapper {
    Socio addRequestToUsuario(AddSocioRequest addSocioRequest);
}
