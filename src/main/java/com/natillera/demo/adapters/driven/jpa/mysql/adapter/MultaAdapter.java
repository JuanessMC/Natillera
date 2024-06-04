package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.MultaEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.entity.SocioEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IMultaEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IMultaRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.ISocioRepository;
import com.natillera.demo.domain.exception.NegativeNotAllowedException;
import com.natillera.demo.domain.model.Multa;
import com.natillera.demo.domain.spi.IMultaPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MultaAdapter implements IMultaPersistencePort {

    private final IMultaRepository multaRepository;
    private final ISocioRepository socioRepository;
    private final IMultaEntityMapper multaEntityMapper;

    @Override
    public String addOrUpdateMulta(Multa multa) {
        try {
            Optional<SocioEntity> optionalSocioEntity = Optional.ofNullable(socioRepository.findByCedula(multa.getCedula()));

            if (!optionalSocioEntity.isPresent()) {
                throw new NegativeNotAllowedException("Socio no encontrado");
            }

            SocioEntity socioEntity = optionalSocioEntity.get();
            MultaEntity multaEntity = multaEntityMapper.toEntity(multa);
            multaEntity.setSocio(socioEntity);
            Optional<MultaEntity> optionalMultaEntity = multaRepository.findById(multa.getIdMulta());

            if (optionalMultaEntity.isPresent()) {
                multaRepository.updateByIdMulta(multaEntity, multa.getIdMulta());
                return "Multa actualizada exitosamente";
            } else {
                multaRepository.save(multaEntity);
                return "Nueva multa creada exitosamente";
            }
        } catch (Exception e) {
            throw new NegativeNotAllowedException(e.getMessage());
        }
    }
}
