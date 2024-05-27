package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.SocioEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.ISocioEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IUsuarioEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.ISocioRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.exception.NegativeNotAllowedException;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SocioAdapter implements ISocioPersistencePort {

    private final ISocioRepository socioRepository;
    private final ISocioEntityMapper socioEntityMapper;
    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioEntityMapper usuarioEntityMapper;

    @Override
    public void saveSocio(Socio socio) {
        try {
            UsuarioEntity usuarioEntity = usuarioEntityMapper.toEntity(socio);
            usuarioRepository.save(usuarioEntity);

            SocioEntity socioEntity = socioEntityMapper.toEntity(socio);
            socioRepository.save(socioEntity);

        }catch (Exception e)
        {
            String error = e.getMessage();
            throw new NegativeNotAllowedException(error);
        }
    }
}
