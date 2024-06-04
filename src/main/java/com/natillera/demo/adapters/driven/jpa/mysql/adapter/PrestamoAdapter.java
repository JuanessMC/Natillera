package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.PrestamoEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IPrestamoMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IPrestamoRepository;
import com.natillera.demo.domain.exception.NegativeNotAllowedException;
import com.natillera.demo.domain.model.Prestamo;
import com.natillera.demo.domain.spi.IPrestamoPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PrestamoAdapter implements IPrestamoPersistencePort {

    private final IPrestamoRepository prestamoRepository;
    private final IPrestamoMapper prestamoEntityMapper;

    @Override
    public List<Prestamo> getAllPrestamos() {
        try {
            List<PrestamoEntity> prestamos = prestamoRepository.findAll();
            return prestamos.stream()
                    .map(prestamoEntityMapper::toModel)
                    .toList();
        } catch (Exception e) {
            throw new NegativeNotAllowedException(e.getMessage());
        }
    }

    @Override
    public Prestamo getPrestamoById(Long idPrestamo) {
        PrestamoEntity prestamoEntity = prestamoRepository.findById(idPrestamo)
                .orElseThrow(() -> new NegativeNotAllowedException("Prestamo no encontrado"));
        return prestamoEntityMapper.toModel(prestamoEntity);
    }

    @Override
    public void updatePrestamo(Prestamo prestamo) {
        try {
            PrestamoEntity prestamoEntity = prestamoRepository.findByIdPrestamo(prestamo.getIdPrestamo());
            prestamoRepository.updateById(prestamoEntity, prestamoEntity.getIdPrestamo());
        } catch (Exception e) {
            throw new NegativeNotAllowedException(e.getMessage());
        }
    }
}
