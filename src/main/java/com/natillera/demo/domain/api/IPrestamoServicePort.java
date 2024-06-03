package com.natillera.demo.domain.api;

import com.natillera.demo.domain.model.Prestamo;

import java.util.List;

public interface IPrestamoServicePort {

    List<Prestamo> getAllPrestamos();
    Prestamo getPrestamoById(Long idPrestamo);
    void updatePrestamo(Prestamo prestamo);

}
