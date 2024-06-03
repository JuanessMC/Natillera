package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IUsuarioEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.exception.NegativeNotAllowedException;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SocioAdapter implements ISocioPersistencePort {

    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioEntityMapper usuarioEntityMapper;

    @Override
    public void saveSocio(Socio socio) {

        try {
            UsuarioEntity usuarioEntity = usuarioEntityMapper.toEntity(socio);
            usuarioRepository.save(usuarioEntity);
        }catch (Exception e)
        {
            throw new NegativeNotAllowedException("Error al crear el usuario");
        }
    }

    @Override
    public Socio getSocio(long id) {
        try {
            UsuarioEntity usuarioEntity = usuarioRepository.findByCedula(id);
            return usuarioEntityMapper.toModel(usuarioEntity);
        }catch (Exception e)
        {
            throw new NegativeNotAllowedException(e.getMessage());
        }
    }

    @Override
    public List<Socio> getAllSocio() {
        try {
            return usuarioEntityMapper.toModelList(usuarioRepository.findAll());
        }catch (Exception e)
        {
            throw new NegativeNotAllowedException(e.getMessage());
        }
    }
}
