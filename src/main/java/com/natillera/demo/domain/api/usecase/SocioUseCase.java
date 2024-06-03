package com.natillera.demo.domain.api.usecase;

import com.natillera.demo.domain.api.ISocioServicePort;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;

import java.util.List;

public class SocioUseCase implements ISocioServicePort {

    private final ISocioPersistencePort socioPersistencePort;

    public SocioUseCase(ISocioPersistencePort socioPersistencePort) {
        this.socioPersistencePort = socioPersistencePort;
    }

    @Override
    public void addSocio(Socio socio) {
        socioPersistencePort.saveSocio(socio);
    }

    @Override
    public Socio getSocio(long id) {
        return socioPersistencePort.getSocio(id);
    }

    @Override
    public List<Socio> getAllSocio() {
        return socioPersistencePort.getAllSocio();
    }

    @Override
    public void updateSocio(Socio socio) {
        socioPersistencePort.updateSocio(socio);
    }
}
