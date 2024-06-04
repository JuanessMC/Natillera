package com.natillera.demo.domain.api.usecase;

import com.natillera.demo.domain.api.IMultaServicePort;
import com.natillera.demo.domain.model.Multa;
import com.natillera.demo.domain.spi.IMultaPersistencePort;

public class MultaUseCase implements IMultaServicePort {

    private final IMultaPersistencePort multaPersistencePort;

    public MultaUseCase(IMultaPersistencePort multaServicePort) {
        multaPersistencePort = multaServicePort;
    }

    @Override
    public String addOrUpdateMulta(Multa multa) {
        return multaPersistencePort.addOrUpdateMulta(multa);
    }
}
