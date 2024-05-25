package com.uis.MediConnect.Service;

import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.Chat;
import com.uis.MediConnect.Model.Cita;
import com.uis.MediConnect.Repository.ChatRepository;
import com.uis.MediConnect.Repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CitaService implements ICitaService {

    private final CitaRepository citaRepository;
    private final ChatRepository chatRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository, ChatRepository chatRepository) {
        this.citaRepository = citaRepository;
        this.chatRepository = chatRepository;
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

    @Override
    public List<CitaDTO> buscarCitaPorIdPaciente(String idPaciente) {
        List<Cita> citas =  citaRepository.findAllByIdPaciente(idPaciente);
        List<CitaDTO> citasDto = new ArrayList<>();
        if(!citas.isEmpty()) {
            String idChat;
            for (Cita cita : citas) {
                Chat chat = chatRepository.findByIdCita(cita.getIdCita());
                idChat = null;
                if (chat != null) {
                    idChat = chat.getIdChat();
                }
                CitaDTO citaDTO = new CitaDTO.Builder().IdCita(cita.getIdCita())
                        .FechaCita(cita.getFechaCita()).IdModalidadCita(cita.getIdModalidadCita())
                        .IdPaciente(cita.getIdPaciente()).IdEspecialidad(cita.getIdEspecialidad())
                        .IdFranjaHoraria(cita.getIdFranjaHoraria())
                        .IdIps(cita.getIdIps()).IdChat(idChat).
                        IdMedico(cita.getIdMedico()).build();
                citasDto.add(citaDTO);
            }
        }
        return citasDto;
    }
    
    //Método para obtener las citas asociadas a un médico
    @Override
    public List<CitaDTO> buscarCitaPorIdMedico(String idmedico) {
        List<Cita> citas =  citaRepository.findALLByIdMedico(idmedico);
        List<CitaDTO> citasDto = new ArrayList<>();
        if(!citas.isEmpty()) {
            String idChat;
            for (Cita cita : citas) {
                Chat chat = chatRepository.findByIdCita(cita.getIdCita());
                idChat = null;
                if (chat != null) {
                    idChat = chat.getIdChat();
                }
                CitaDTO citaDTO = new CitaDTO.Builder().IdCita(cita.getIdCita())
                        .FechaCita(cita.getFechaCita()).IdModalidadCita(cita.getIdModalidadCita())
                        .IdPaciente(cita.getIdPaciente()).IdEspecialidad(cita.getIdEspecialidad())
                        .IdFranjaHoraria(cita.getIdFranjaHoraria())
                        .IdIps(cita.getIdIps()).IdChat(idChat).
                        IdMedico(cita.getIdMedico()).build();
                citasDto.add(citaDTO);
            }
        }
        return citasDto;
    }
    
}
