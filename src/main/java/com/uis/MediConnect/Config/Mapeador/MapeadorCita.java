package com.uis.MediConnect.Config.Mapeador;

import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.*;
import com.uis.MediConnect.Repository.*;

import java.util.ArrayList;
import java.util.List;

public class MapeadorCita implements IMapeadorCita {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final EspecialidadRepository especialidadRepository;
    private final IpsRepository ipsRepository;
    private final ModalidadCitaRepository modalidadCitaRepository;
    private final CiudadanoRepository ciudadanoRepository;
    private final ChatRepository chatRepository;

    public MapeadorCita(FranjaHorariaRepository franjaHorariaRepository, EspecialidadRepository especialidadRepository, IpsRepository ipsRepository, ModalidadCitaRepository modalidadCitaRepository, CiudadanoRepository ciudadanoRepository, ChatRepository chatRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.especialidadRepository = especialidadRepository;
        this.ipsRepository = ipsRepository;
        this.modalidadCitaRepository = modalidadCitaRepository;
        this.ciudadanoRepository = ciudadanoRepository;
        this.chatRepository = chatRepository;
    }
    @Override
    public List<CitaDTO> mapearCitaACitaDTO(List<Cita> citas) {
        List<CitaDTO> citasDto = new ArrayList<>();
        if(!citas.isEmpty()) {
            String idChat;
            for (Cita cita : citas) {
                Chat chat = chatRepository.findByIdCita(cita.getIdCita());
                Especialidad especialidad = especialidadRepository.findById(cita.getIdEspecialidad()).orElse(null);
                FranjaHoraria franjaHoraria = franjaHorariaRepository.findById(cita.getIdFranjaHoraria()).orElse(null);
                Ips ips = ipsRepository.findById(cita.getIdIps()).orElse(null);
                ModalidadCita modalidadCita = modalidadCitaRepository.findById(cita.getIdModalidadCita()).orElse(null);
                Ciudadano medico = ciudadanoRepository.findById(cita.getIdMedico()).orElse(null);
                idChat = null;
                if (chat != null) {
                    idChat = chat.getIdChat();
                }
                CitaDTO citaDTO = new CitaDTO.Builder()
                        .IdCita(cita.getIdCita())
                        .Especialidad(especialidad.getDescripcion())
                        .FranjaHoraria(franjaHoraria.getDescripcion())
                        .Ips(ips.getDescripcion())
                        .urlIps(ips.getUrl())
                        .ModalidadCita(modalidadCita.getDescripcion())
                        .FechaCita(cita.getFechaCita())
                        .IdPaciente(cita.getIdPaciente())
                        .Medico(medico.getNombres()+" "+medico.getApellidos())
                        .IdChat(idChat)
                        .build();
                citasDto.add(citaDTO);
            }

            return citasDto;
        }

        return null;
    }
}
