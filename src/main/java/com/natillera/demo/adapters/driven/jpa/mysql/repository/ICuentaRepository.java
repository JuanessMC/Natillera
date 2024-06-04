package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.CuentaEntity;
import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ICuentaRepository extends JpaRepository<CuentaEntity, Long> {
    Optional<CuentaEntity> findByUsuario(UsuarioEntity usuario);
    @Modifying
    @Transactional
    @Query("UPDATE CuentaEntity c SET c.nombreBanco = :#{#cuenta.nombreBanco}, c.numeroCuenta = :#{#cuenta.numeroCuenta} WHERE c.usuario.cedula = :cedula")
    void updateCuentaByUsuarioCedula(@Param("cuenta") CuentaEntity cuenta, @Param("cedula") Long cedula);
}