package com.uis.MediConnect.Service;

import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.Cita;

import java.util.List;

public interface ICitaService {

    Cita guardarCita(Cita cita);
    Cita buscarCita(String idCita);
    List<Cita> buscarTodasCitas();
    Cita editarCita(Cita cita);
    Cita eliminarCita(String idCita);

    List<CitaDTO> buscarCitaPorIdPaciente(String idPaciente);
    
    //Método para obtener las citas asociadas a un médico
    public List<CitaDTO> buscarCitaPorIdMedico(String idmedico);
}
