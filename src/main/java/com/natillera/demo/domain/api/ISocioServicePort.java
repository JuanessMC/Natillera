package com.natillera.demo.domain.api;

import com.natillera.demo.domain.model.Socio;

public interface ISocioServicePort {
    void addSocio(Socio socio);
    Socio getSocio(long id);
}
