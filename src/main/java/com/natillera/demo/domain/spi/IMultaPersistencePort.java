package com.natillera.demo.domain.spi;

import com.natillera.demo.domain.model.Multa;
public interface IMultaPersistencePort {

    String saveMulta(Multa multa);
}
