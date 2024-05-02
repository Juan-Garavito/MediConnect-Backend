package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.HistoriaClinica;
import com.uis.MediConnect.Repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoriaClinicaService implements IHistoriaClinicaService{


    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    public HistoriaClinicaService(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historia) {
        return historiaClinicaRepository.save(historia);
    }

    @Override
    public HistoriaClinica buscarHistoriaClinica(String idHistoria) {
        return historiaClinicaRepository.findById(idHistoria).orElse(null);
    }

    @Override
    public List<HistoriaClinica> buscarTodasHistoriaClinica() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica editarHistoriaClinica(HistoriaClinica historia) {
        HistoriaClinica historiaClinica = buscarHistoriaClinica(historia.getIdHistoriaClinica());
        if(historiaClinica != null){
            guardarHistoriaClinica(historia);
            return historia;
        }
        return null;
    }

    @Override
    public HistoriaClinica eliminarHistoriaClinica(String idHistoria) {
        HistoriaClinica historiaClinica = buscarHistoriaClinica(idHistoria);
        if (historiaClinica != null){
            historiaClinicaRepository.delete(historiaClinica);
            return historiaClinica;
        }
        return null;
    }
}
