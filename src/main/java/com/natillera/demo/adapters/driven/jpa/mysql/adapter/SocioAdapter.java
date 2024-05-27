package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.mapper.ISocioEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.ISocioRepository;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SocioAdapter implements ISocioPersistencePort {

    private final ISocioRepository socioRepository;
    private final ISocioEntityMapper socioEntityMapper;
    @Override
    public void saveSocio(Socio socio) {
        try {
            socioRepository.save(socioEntityMapper.toEntity(socio));
        }catch (Exception e)
        {
            throw new NegativeArraySizeException(e.getMessage());
        }
    }
}
