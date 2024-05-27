package com.natillera.demo.domain.api.usecase;

import com.natillera.demo.domain.api.ISocioServicePort;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
public class SocioUseCase implements ISocioServicePort {

    private final ISocioPersistencePort socioPersistencePort;

    public SocioUseCase(ISocioPersistencePort socioPersistencePort) {
        this.socioPersistencePort = socioPersistencePort;
    }

    @Override
    public void addSocio(Socio socio) {
        socioPersistencePort.saveSocio(socio);
    }
}
