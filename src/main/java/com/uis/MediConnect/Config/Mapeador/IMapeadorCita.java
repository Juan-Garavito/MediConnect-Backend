package com.uis.MediConnect.Config.Mapeador;

import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.Cita;

import java.util.List;

public interface IMapeadorCita {
    List<CitaDTO> mapearCitaACitaDTO(List<Cita> citas);
}
