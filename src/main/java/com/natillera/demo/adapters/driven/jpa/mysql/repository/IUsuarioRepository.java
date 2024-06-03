package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByCedula(long cedula);
    @Modifying
    @Transactional
    @Query("UPDATE UsuarioEntity u SET u = :usuarioEntity WHERE u.cedula = :cedula")
    void updateByCedula(@Param("usuarioEntity") UsuarioEntity usuarioEntity, @Param("cedula") long cedula);
}