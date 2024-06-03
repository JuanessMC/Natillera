package com.natillera.demo.domain.api.usecase;

import com.natillera.demo.domain.api.IPrestamoServicePort;
import com.natillera.demo.domain.model.Prestamo;
import com.natillera.demo.domain.spi.IPrestamoPersistencePort;

import java.util.List;

public class PrestamoUseCase implements IPrestamoServicePort {

    private final IPrestamoPersistencePort prestamoPersistencePort;

    public PrestamoUseCase(IPrestamoPersistencePort prestamoPersistencePort) {
        this.prestamoPersistencePort = prestamoPersistencePort;
    }

    @Override
    public List<Prestamo> getAllPrestamos() {
        return List.of();
    }

    @Override
    public Prestamo getPrestamoById(Long idPrestamo) {
        return null;
    }

    @Override
    public void updatePrestamo(Prestamo prestamo) {

    }
}
