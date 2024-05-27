package com.natillera.demo.domain.spi;

import com.natillera.demo.domain.model.Socio;

public interface ISocioPersistencePort {
    void saveSocio(Socio socio);
}
