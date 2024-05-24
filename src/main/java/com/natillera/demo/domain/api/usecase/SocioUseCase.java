package com.natillera.demo.domain.api.usecase;

import com.natillera.demo.domain.api.ISocioUseCase;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SocioUseCase implements ISocioUseCase {

    private final ISocioPersistencePort ISocioPersistencePort;

    @Override
    public void AddSocio(Socio socio) {
        ISocioPersistencePort.saveSocio(socio);
    }
}
