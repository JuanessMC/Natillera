package com.natillera.demo.domain.api;

import com.natillera.demo.domain.model.Socio;

import java.util.List;

public interface ISocioServicePort {
    void addSocio(Socio socio);
    Socio getSocio(long id);
    List<Socio> getAllSocio();
    void updateSocio(Socio socio);
}
