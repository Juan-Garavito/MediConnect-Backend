package com.uis.MediConnect.Service;

import com.uis.MediConnect.Config.Mapeador.MapeadorCita;
import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.*;
import com.uis.MediConnect.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


@Service
@Transactional
public class CitaService implements ICitaService {

    private final CitaRepository citaRepository;
    private final ChatRepository chatRepository;
    private final MensajeRepository mensajeRepository;
    private final MapeadorCita mapeadorCita;
    @PersistenceContext
    EntityManager entityManager;
    private final DisponibilidadMedicoRepository disponibilidadMedicoRepository;
    private final ChatService chatService;


    @Autowired
    public CitaService(CitaRepository citaRepository, ChatRepository chatRepository, FranjaHorariaRepository franjaHorariaRepository, EspecialidadRepository especialidadRepository, IpsRepository ipsRepository, ModalidadCitaRepository modalidadCitaRepository, CiudadanoRepository ciudadanoRepository, MensajeRepository mensajeRepository, MapeadorCita mapeadorCita, ChatService chatService, DisponibilidadMedicoRepository disponibilidadMedicoRepository) {
        this.citaRepository = citaRepository;
        this.chatRepository = chatRepository;
        this.mensajeRepository = mensajeRepository;
        this.mapeadorCita = mapeadorCita;
        this.chatService = chatService;
        this.disponibilidadMedicoRepository = disponibilidadMedicoRepository;
    }


    @Override
    public Cita guardarCita(Cita cita) {
        List<DisponibilidadMedico> disponibilidadMedicos = disponibilidadMedicoRepository.findAllByIdMedicoAnFechaWithEstado(cita.getIdMedico(), cita.getFechaCita(), false);

        for(DisponibilidadMedico disponibilidadMedico : disponibilidadMedicos){
            if(disponibilidadMedico.getIdFranjaHoraria().getId() == cita.getIdFranjaHoraria()){
                disponibilidadMedico.setEstado(true);
                disponibilidadMedicoRepository.save(disponibilidadMedico);
                break;
            }
        }

        citaRepository.save(cita);
        if(cita.getIdModalidadCita().equals(2)){
            Chat chat = chatRepository.findByIdCita(cita.getIdCita());
            if(chat == null){
                chatService.crearIdChat(cita.getIdCita());
            }
        }

        return cita;
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

        List<DisponibilidadMedico> odlDisponibilidad = disponibilidadMedicoRepository.findAllByIdMedicoAnFechaWithEstado(oldCita.getIdMedico(), oldCita.getFechaCita(), true);
        for(DisponibilidadMedico disponibilidadMedico : odlDisponibilidad){
            if(disponibilidadMedico.getIdFranjaHoraria().getId() == oldCita.getIdFranjaHoraria()){
                disponibilidadMedico.setEstado(false);
                disponibilidadMedicoRepository.save(disponibilidadMedico);
                break;
            }
        }

        List<DisponibilidadMedico> newDisponibilidad = disponibilidadMedicoRepository.findAllByIdMedicoAnFechaWithEstado(cita.getIdMedico(), cita.getFechaCita(), false);
        for(DisponibilidadMedico disponibilidadMedico : newDisponibilidad){
            if(disponibilidadMedico.getIdFranjaHoraria().getId() == cita.getIdFranjaHoraria()){
                disponibilidadMedico.setEstado(true);
                disponibilidadMedicoRepository.save(disponibilidadMedico);
                break;
            }
        }

        if(oldCita.getIdModalidadCita().equals(2) & cita.getIdModalidadCita().equals(1)){
            Chat chat = chatRepository.findByIdCita(cita.getIdCita());
            if(chat != null){
                chatRepository.deleteById(chat.getIdChat());
            }
        }

        if(oldCita != null){
            return guardarCita(cita);
        }
        return null;
    }

    @Override
    public Cita eliminarCita(String idCita) {
        Cita cita = buscarCita(idCita);

        if(cita != null){
            System.out.println("Cita IPS: "+ cita.getIdIps());
            System.out.println("Cita ID: "+ cita.getIdCita());

            if(cita.getIdModalidadCita().equals(2)){
                Chat chat = chatRepository.findByIdCita(cita.getIdCita());
                System.out.println("Cita ID: "+ cita.getIdCita());
                System.out.println("chat: "+ cita.getIdCita());
                if(chat != null){
                    List<Mensaje> mensajes = mensajeRepository.findAllByIdChat(chat.getIdChat());
                    mensajeRepository.deleteAll(mensajes);
                    chatRepository.delete(chat);
                }
            }

            List<DisponibilidadMedico> disponibilidadMedicos = disponibilidadMedicoRepository.findAllByIdMedicoAnFechaWithEstado(cita.getIdMedico(), cita.getFechaCita(), true);
            for(DisponibilidadMedico disponibilidadMedico : disponibilidadMedicos){
                if(disponibilidadMedico.getIdFranjaHoraria().getId() == cita.getIdFranjaHoraria()){
                    disponibilidadMedico.setEstado(false);
                    disponibilidadMedicoRepository.save(disponibilidadMedico);
                    break;
                }
            }

            citaRepository.deleteById(idCita);
            return cita;
        }
        return null;
    }

    @Override
    public List<CitaDTO> buscarCitaPorIdPaciente(String idPaciente) {
        LocalDate dateNow = LocalDate.now(ZoneId.of("America/Bogota"));
        List<Cita> citas =  citaRepository.findAllByIdPacienteOrderByFechaCitaAhora(idPaciente, dateNow);
        List<CitaDTO> citasDto = mapeadorCita.mapearCitaACitaDTO(citas);
        return citasDto;
    }

    @Override
    public List<CitaDTO> buscarCitaPorIdMedico(String idmedico) {
        return null;
    }

    @Override
    public List<CitaDTO> buscarCitaPorIdPacienteConLimite(String idPaciente, int maxLimit) {
        LocalDate dateNow = LocalDate.now(ZoneId.of("America/Bogota"));
        List<Cita> citas = citaRepository.findAllByIdPacienteOrderByFechaCitaConLimiteAHora(idPaciente, maxLimit, dateNow);
        List<CitaDTO> citasDto = mapeadorCita.mapearCitaACitaDTO(citas);
        return citasDto;
    }

    @Override
    public List<CitaDTO> buscarCitaPorIdMedicoFecha(String idMedico, LocalDate fechaCita) {
        String query = "SELECT c FROM Cita c WHERE c.idMedico = :idmedico AND c.fechaCita = :fechacita";

        TypedQuery<Cita> typedQuery = entityManager.createQuery(query, Cita.class)
                .setParameter("idmedico", idMedico)
                .setParameter("fechacita", fechaCita);

        List<Cita> citas = typedQuery.getResultList();

        List<CitaDTO> citasDto = mapeadorCita.mapearCitaACitaDTOMedico(citas);

        return citasDto;
    }

}
