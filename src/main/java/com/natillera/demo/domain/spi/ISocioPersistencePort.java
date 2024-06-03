package com.natillera.demo.domain.spi;

import com.natillera.demo.domain.model.Socio;

import java.util.List;

public interface ISocioPersistencePort {
    void saveSocio(Socio socio);
    Socio getSocio(long id);
    List<Socio> getAllSocio();

}
