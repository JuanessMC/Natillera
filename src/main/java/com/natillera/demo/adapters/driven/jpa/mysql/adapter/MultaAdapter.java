package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IMultaEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IMultaRepository;

import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.model.Multa;
import com.natillera.demo.domain.spi.IMultaPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MultaAdapter implements IMultaPersistencePort {

    private final IMultaRepository multaRepository;
    private final IMultaEntityMapper multaEntityMapper;
    private final IUsuarioRepository usuarioRepository;


    @Override
    public String saveMulta(Multa multa) {
        try {
            Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findByCedula(multa.getCedula());
            if (optionalUsuarioEntity.isPresent()) {
                multaRepository.save(multaEntityMapper.toEntity(multa));
                return "Multa agregada exitosamente";
            } else {

                throw new RuntimeException("No se encontro ningún usuario con la cedula proporcionada.");
            }
        } catch (Exception e) {
            return "Error al guardar la multa: " + e.getMessage();
        }
    }
}
