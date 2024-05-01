package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Cita;
import com.uis.MediConnect.Model.Ciudadano;

import java.util.List;

public interface ICitaServie {

    Cita guardarCita(Cita cita);
    Cita buscarCita(String idCita);
    List<Cita> buscarTodasCitas();
    Cita editarCita(Cita cita);
    Cita eliminarCita(String idCita);

}
