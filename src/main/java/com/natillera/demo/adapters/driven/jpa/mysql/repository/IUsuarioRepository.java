package com.natillera.demo.adapters.driven.jpa.mysql.repository;

import com.natillera.demo.adapters.driven.jpa.mysql.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE UsuarioEntity u SET u.nombre = :#{#usuario.nombre}, u.apellidos = :#{#usuario.apellidos}, " +
            "u.correoElectronico = :#{#usuario.correoElectronico}, u.estado = :#{#usuario.estado}, " +
            "u.fechaNacimiento = :#{#usuario.fechaNacimiento} WHERE u.cedula = :cedula")
    void updateUsuarioByCedula(@Param("usuario") UsuarioEntity usuario, @Param("cedula") Long cedula);

    @Modifying
    @Transactional
    @Query("UPDATE SocioEntity s SET s.salarioMensual = :#{#usuario.socio.salarioMensual} WHERE s.cedula = :cedula")
    void updateSocioByUsuarioCedula(@Param("usuario") UsuarioEntity usuario, @Param("cedula") Long cedula);

    @Modifying
    @Query("UPDATE UsuarioEntity u SET u.estado = :estado WHERE u.cedula = :cedula")
    void updateEstadoByCedula(@Param("estado") boolean estado, @Param("cedula") Long cedula);

    Optional<UsuarioEntity> findByCedula(Long cedula);

    @Query(value = "SELECT name, value, total FROM (" +
            "    SELECT 'Intereses' AS name, SUM(p.valor_prestamo * p.tasa_interes / 100) AS value, " +
            "           (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE estado_pago = 'pagado') + " +
            "           (SELECT SUM(valor_multa) FROM multa) + " +
            "           (SELECT SUM(valor_aporte) FROM aporte) AS total " +
            "    FROM prestamo p WHERE p.estado_pago = 'pagado' " +
            "    UNION ALL " +
            "    SELECT 'Multas' AS name, SUM(m.valor_multa) AS value, " +
            "           (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE estado_pago = 'pagado') + " +
            "           (SELECT SUM(valor_multa) FROM multa) + " +
            "           (SELECT SUM(valor_aporte) FROM aporte) AS total " +
            "    FROM multa m " +
            "    UNION ALL " +
            "    SELECT 'Aportes' AS name, SUM(a.valor_aporte) AS value, " +
            "           (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE estado_pago = 'pagado') + " +
            "           (SELECT SUM(valor_multa) FROM multa) + " +
            "           (SELECT SUM(valor_aporte) FROM aporte) AS total " +
            "    FROM aporte a" +
            ") AS subquery",
            nativeQuery = true)
    List<Map<String, Object>> getPagosResumen();


    @Query(value = "SELECT 'Enero-Abril' AS name, SUM(valor_prestamo * tasa_interes / 100) AS value, " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 1 AND 4 AND estado_pago = 'pagado') + " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 5 AND 9 AND estado_pago = 'pagado') + " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 10 AND 12 AND estado_pago = 'pagado') AS total " +
            "FROM prestamo WHERE MONTH(fecha) BETWEEN 1 AND 4 AND estado_pago = 'pagado' " +
            "UNION ALL " +
            "SELECT 'Mayo-Septiembre' AS name, SUM(valor_prestamo * tasa_interes / 100) AS value, " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 1 AND 4 AND estado_pago = 'pagado') + " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 5 AND 9 AND estado_pago = 'pagado') + " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 10 AND 12 AND estado_pago = 'pagado') AS total " +
            "FROM prestamo WHERE MONTH(fecha) BETWEEN 5 AND 9 AND estado_pago = 'pagado' " +
            "UNION ALL " +
            "SELECT 'Octubre-Diciembre' AS name, SUM(valor_prestamo * tasa_interes / 100) AS value, " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 1 AND 4 AND estado_pago = 'pagado') + " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 5 AND 9 AND estado_pago = 'pagado') + " +
            "       (SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE MONTH(fecha) BETWEEN 10 AND 12 AND estado_pago = 'pagado') AS total " +
            "FROM prestamo WHERE MONTH(fecha) BETWEEN 10 AND 12 AND estado_pago = 'pagado'",
            nativeQuery = true)
    List<Map<String, Object>> getInteresesPorPeriodo();


    @Query(value = "SELECT SUM(valor_aporte) FROM aporte", nativeQuery = true)
    Double getTotalAportes();

    @Query(value = "SELECT SUM(valor_multa) FROM multa", nativeQuery = true)
    Double getTotalMultas();

    @Query(value = "SELECT SUM(valor_prestamo * tasa_interes / 100) FROM prestamo WHERE estado_pago = 'pagado'", nativeQuery = true)
    Double getTotalInteresesPagados();

    @Query(value = "SELECT SUM(ganancias) FROM actividad", nativeQuery = true)
    Double getTotalActividades();



}
