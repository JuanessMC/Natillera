package com.natillera.demo.configuration;

import com.natillera.demo.adapters.driven.jpa.mysql.adapter.SocioAdapter;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.ISocioEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.ISocioRepository;
import com.natillera.demo.domain.api.ISocioServicePort;
import com.natillera.demo.domain.api.usecase.SocioUseCase;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ISocioRepository socioRepository;
    private final ISocioEntityMapper socioEntityMapper;

    @Bean
    public ISocioPersistencePort socioPersistencePort()
    {
        return new SocioAdapter(socioRepository, socioEntityMapper);
    }

    @Bean
    public ISocioServicePort socioServicePort()
    {
        return new SocioUseCase(socioPersistencePort());
    }
}
