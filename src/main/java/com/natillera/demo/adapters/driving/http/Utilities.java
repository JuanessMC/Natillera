package com.natillera.demo.adapters.driving.http;

import com.natillera.demo.adapters.driving.http.dto.response.PrestamoResponse;
import com.natillera.demo.adapters.driving.http.dto.response.PrestamoResponseList;
import com.natillera.demo.adapters.driving.http.mapper.IPrestamoResponseMapper;
import com.natillera.demo.adapters.driving.http.mapper.IUtilities;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Utilities implements IUtilities {

    private  final ISocioPersistencePort socioPersistencePort;
    private final IPrestamoResponseMapper prestamoResponseMapper;


    @Override
    public PrestamoResponseList addNameToPrestamoResponseList(PrestamoResponseList prestamoResponseList) {
        List<PrestamoResponse> responseList = new ArrayList<>();

        PrestamoResponseList prestamos = new PrestamoResponseList();

        prestamoResponseList.getResponseList().stream()
                .map(prestamoResponse -> {
                    Socio socio = socioPersistencePort.getSocio(Long.parseLong(prestamoResponse.getCedula()));
                    prestamoResponse.setNombre(socio.getNombre());
                    prestamoResponse.setApellido(socio.getApellidos());
                    return prestamoResponse;
                }).forEach(responseList::add);

        prestamos.setResponseList(responseList);

        return prestamos;
    }

}
