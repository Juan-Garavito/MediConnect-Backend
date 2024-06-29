package com.uis.MediConnect.Service;

import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.Cita;
import net.sf.jsqlparser.statement.select.Limit;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface ICitaService {

    Cita guardarCita(Cita cita);
    Cita buscarCita(String idCita);
    List<Cita> buscarTodasCitas();
    Cita editarCita(Cita cita);
    Cita eliminarCita(String idCita);
    List<CitaDTO> buscarCitaPorIdPaciente(String idPaciente);
    List<CitaDTO> buscarCitaPorIdPacienteConLimite(String idPaciente, int maxlimit);
    List<CitaDTO> buscarCitaPorIdMedicoFecha(String Medico, LocalDate fechaCita);

}
