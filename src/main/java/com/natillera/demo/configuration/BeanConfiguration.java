package com.natillera.demo.configuration;

import com.natillera.demo.adapters.driven.jpa.mysql.adapter.MultaAdapter;
import com.natillera.demo.adapters.driven.jpa.mysql.adapter.SocioAdapter;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IMultaEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IUsuarioEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.ICuentaRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IMultaRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.ISocioRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.api.IMultaServicePort;
import com.natillera.demo.domain.api.ISocioServicePort;
import com.natillera.demo.domain.api.usecase.MultaUseCase;
import com.natillera.demo.domain.api.usecase.SocioUseCase;
import com.natillera.demo.domain.spi.IMultaPersistencePort;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioEntityMapper usuarioEntityMapper;
    private final ICuentaRepository cuentaRepository;
    private final IMultaRepository multaRepository;
    private final IMultaEntityMapper multaEntityMapper;
    private final ISocioRepository socioRepository;


    @Bean
    public ISocioPersistencePort socioPersistencePort()
    {
        return new SocioAdapter(usuarioRepository, usuarioEntityMapper, cuentaRepository);
    }

    @Bean
    public ISocioServicePort socioServicePort()
    {
        return new SocioUseCase(socioPersistencePort());
    }

    @Bean
    public IMultaPersistencePort multaPersistencePort()
    {
        return new MultaAdapter( multaRepository, socioRepository, multaEntityMapper);
    }

    @Bean
    public IMultaServicePort multaServicePort()
    {
        return new MultaUseCase(multaPersistencePort());
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
