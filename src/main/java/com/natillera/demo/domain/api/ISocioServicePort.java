package com.natillera.demo.domain.api;

import com.natillera.demo.domain.model.Socio;

import java.util.List;

public interface ISocioServicePort {
    String addOrUpdateSocio(Socio socio);
    Socio getSocio(long id);
    List<Socio> getAllSocio();
    void updateSocioByEstado(Socio socio);
}
