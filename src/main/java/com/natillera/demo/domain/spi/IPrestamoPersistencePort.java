package com.natillera.demo.domain.spi;

import com.natillera.demo.domain.model.Prestamo;

import java.util.List;

public interface IPrestamoPersistencePort {

    List<Prestamo> getAllPrestamos();
    Prestamo getPrestamoById(Long idPrestamo);
    void updatePrestamo(Prestamo prestamo);
}
