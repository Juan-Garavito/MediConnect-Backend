package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, String> {

    List<Cita> findAllByIdPaciente(String idpaciente);
    //Método para obtener las citas asociadas a un médico
    public List<Cita> findALLByIdMedico(String idmedico);
}
