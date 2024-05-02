package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Cita;
import com.uis.MediConnect.Repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CitaService implements ICitaService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }


    @Override
    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Cita buscarCita(String idCita) {
        return citaRepository.findById(idCita).orElse(null);
    }

    @Override
    public List<Cita> buscarTodasCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita editarCita(Cita cita) {
        Cita oldCita = buscarCita(cita.getIdCita());
        if(oldCita != null){
            return guardarCita(cita);
        }
        return oldCita;
    }

    @Override
    public Cita eliminarCita(String idCita) {
        Cita cita = buscarCita(idCita);
        if(cita != null){
            citaRepository.deleteById(idCita);
            return cita;
        }
        return null;
    }
}
