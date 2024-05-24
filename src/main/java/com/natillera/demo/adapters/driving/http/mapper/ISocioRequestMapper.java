package com.natillera.demo.adapters.driving.http.mapper;

import com.natillera.demo.adapters.driving.http.dto.request.AddSocioRequest;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISocioRequestMapper {
    Socio addRequestToUsuario(AddSocioRequest addSocioRequest);
}
