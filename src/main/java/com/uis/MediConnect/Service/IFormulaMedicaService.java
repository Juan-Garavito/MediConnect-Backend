package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.FormulaMedica;

import java.util.List;

public interface IFormulaMedicaService {
    FormulaMedica guardarFormulaMedica(FormulaMedica formula);
    FormulaMedica buscarFormulaMedica(String idFormula);
    List<FormulaMedica> buscarTodasFormulaMedica();
    FormulaMedica editarFormulaMedica(FormulaMedica formula);
    FormulaMedica eliminarFormulaMedica(String idFormula);
}
