package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.DisponibilidadMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadMedicoRepository extends JpaRepository<DisponibilidadMedico, Integer> {

    @Query(nativeQuery = true,
    value = "select * from disponibilidadmedico where fecha = :fecha and estado = :estado")
    List<DisponibilidadMedico> findAllByFechaAndEstado(@Param("fecha") LocalDate fecha, @Param("estado")  boolean estado);

    @Query(nativeQuery = true,
            value = "select * from disponibilidadmedico where idmedico = :idmedico and estado = :estado")
    List<DisponibilidadMedico> findAllByIdMedicoAndEstado(@Param("idmedico") String idmedico, @Param("estado")  boolean estado);

    @Query(nativeQuery = true,
            value = "select * from disponibilidadmedico where idmedico = :idmedico and fecha = :fecha and estado = :estado")
    List<DisponibilidadMedico> findAllByIdMedicoAnFechaWithEstado(@Param("idmedico") String idmedico, @Param("fecha") LocalDate fecha, @Param("estado")  boolean estado);
 }
