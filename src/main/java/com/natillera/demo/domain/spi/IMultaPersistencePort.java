package com.natillera.demo.domain.spi;

import com.natillera.demo.domain.model.Multa;
import com.natillera.demo.domain.model.Socio;

public interface IMultaPersistencePort {

    String addOrUpdateMulta(Multa multa);
}
