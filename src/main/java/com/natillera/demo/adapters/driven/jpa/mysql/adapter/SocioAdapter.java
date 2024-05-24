package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import org.springframework.stereotype.Component;

@Component
public class SocioAdapter implements ISocioPersistencePort {
    @Override
    public void saveSocio(Socio socio) {
        System.out.println("Socio guardado: " + socio);
    }
}
