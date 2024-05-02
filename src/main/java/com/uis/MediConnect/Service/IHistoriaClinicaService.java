package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.HistoriaClinica;

import java.util.List;

public interface IHistoriaClinicaService {
    HistoriaClinica guardarHistoriaClinica(HistoriaClinica historia);
    HistoriaClinica buscarHistoriaClinica(String idHistoria);
    List<HistoriaClinica> buscarTodasHistoriaClinica();
    HistoriaClinica editarHistoriaClinica(HistoriaClinica historia);
    HistoriaClinica eliminarHistoriaClinica(String isHistoria);
}
