package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.FormulaMedica;
import com.uis.MediConnect.Repository.FormulaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FormulaMedicaService implements IFormulaMedicaService{

    private final FormulaMedicaRepository formulaMedicaRepository;

    @Autowired
    public FormulaMedicaService(FormulaMedicaRepository formulaMedicaRepository) {
        this.formulaMedicaRepository = formulaMedicaRepository;
    }

    @Override
    public FormulaMedica guardarFormulaMedica(FormulaMedica formula) {
        return formulaMedicaRepository.save(formula);
    }

    @Override
    public FormulaMedica buscarFormulaMedica(String idFormula) {
        return formulaMedicaRepository.findById(idFormula).orElse(null);
    }

    @Override
    public List<FormulaMedica> buscarTodasFormulaMedica() {
        return formulaMedicaRepository.findAll();
    }

    @Override
    public FormulaMedica editarFormulaMedica(FormulaMedica formula) {
        FormulaMedica formulaMedica = buscarFormulaMedica(formula.getIdFormulaMedica());
        if (formulaMedica != null){
            guardarFormulaMedica(formula);
            return formula;
        }
        return null;
    }

    @Override
    public FormulaMedica eliminarFormulaMedica(String idFormula) {
        FormulaMedica formulaMedica = buscarFormulaMedica(idFormula);
        if (formulaMedica != null){
            formulaMedicaRepository.delete(formulaMedica);
            return formulaMedica;
        }
        return null;
    }
}
