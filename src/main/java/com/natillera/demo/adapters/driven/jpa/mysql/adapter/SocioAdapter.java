package com.natillera.demo.adapters.driven.jpa.mysql.adapter;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.CuentaEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.mapper.IUsuarioEntityMapper;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.ICuentaRepository;
import com.natillera.demo.adapters.driven.jpa.mysql.repository.IUsuarioRepository;
import com.natillera.demo.domain.exception.GeneralException;
import com.natillera.demo.domain.model.Socio;
import com.natillera.demo.domain.spi.ISocioPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SocioAdapter implements ISocioPersistencePort {

    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioEntityMapper usuarioEntityMapper;
    private final ICuentaRepository cuentaRepository;
    @Override
    public String addOrUpdateSocio(Socio socio) {
        try {
            UsuarioEntity usuario = usuarioEntityMapper.toEntity(socio);
            Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findByCedula(usuario.getCedula());

            if (optionalUsuarioEntity.isPresent()) {
                usuarioRepository.updateUsuarioByCedula(usuario, usuario.getCedula());
                usuarioRepository.updateSocioByUsuarioCedula(usuario, usuario.getCedula());

                CuentaEntity cuenta = CuentaEntity.builder()
                        .numeroCuenta(usuario.getCuenta().getNumeroCuenta())
                        .nombreBanco(usuario.getCuenta().getNombreBanco())
                        .tipoCuenta(usuario.getCuenta().getTipoCuenta())
                        .build();
                cuentaRepository.updateCuentaByUsuarioCedula(cuenta, usuario.getCedula());

                return "Socio actualizado exitosamente";
            } else {
                usuarioRepository.save(usuario);
                return "Nuevo socio creado exitosamente";
            }
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    @Override
    public Socio getSocio(long id) {
        try {
            Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findByCedula(id);
            if (optionalUsuarioEntity.isPresent()) {
                return usuarioEntityMapper.toModel(optionalUsuarioEntity.get());
            } else {
                throw new GeneralException("Usuario no encontrado con la cédula: " + id);
            }
        } catch (Exception e) {
            throw new GeneralException("Error al obtener el usuario con la cédula: " + id + ". " + e.getMessage());
        }
    }

    @Override
    public List<Socio> getAllSocio() {
        try {
            return usuarioEntityMapper.toModelList(usuarioRepository.findAll());
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    public void updateSocioByEstado(Socio socio) {
        try {
            Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findByCedula(socio.getCedula());
            if (optionalUsuarioEntity.isPresent()) {
                usuarioRepository.updateEstadoByCedula(socio.isEstado(), socio.getCedula());
            } else {
                throw new GeneralException("Usuario no encontrado con la cédula: " + socio.getCedula());
            }
        } catch (Exception e) {
            throw new GeneralException("Error al actualizar el estado del usuario: " + e.getMessage());
        }
    }



}
