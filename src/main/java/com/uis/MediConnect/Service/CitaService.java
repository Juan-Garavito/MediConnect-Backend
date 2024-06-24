package com.uis.MediConnect.Service;

import com.uis.MediConnect.Config.Mapeador.MapeadorCita;
import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.*;
import com.uis.MediConnect.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @Autowired
    public CitaService(CitaRepository citaRepository, ChatRepository chatRepository, FranjaHorariaRepository franjaHorariaRepository, EspecialidadRepository especialidadRepository, IpsRepository ipsRepository, ModalidadCitaRepository modalidadCitaRepository, CiudadanoRepository ciudadanoRepository, MensajeRepository mensajeRepository, MapeadorCita mapeadorCita) {
        this.citaRepository = citaRepository;
        this.chatRepository = chatRepository;
        this.mensajeRepository = mensajeRepository;
        this.mapeadorCita = mapeadorCita;
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
            System.out.println("Cita IPS: "+ cita.getIdIps());
            if(cita.getIdIps().equals(10)){
                Chat chat = chatRepository.findByIdCita(cita.getIdCita());
                List<Mensaje> mensajes = mensajeRepository.findAllByIdChatOrderByFechaMensaje(chat.getIdChat());
                mensajeRepository.deleteAll(mensajes);
                chatRepository.delete(chat);
                System.out.println("Cita Chat: " + chat.toString());
            }
            citaRepository.deleteById(idCita);
            return cita;
        }
        return null;
    }

    @Override
    public List<CitaDTO> buscarCitaPorIdPaciente(String idPaciente) {
        List<Cita> citas =  citaRepository.findAllByIdPacienteOrderByFechaCita(idPaciente);
        List<CitaDTO> citasDto = mapeadorCita.mapearCitaACitaDTO(citas);
        return citasDto;
    }

    @Override
    public List<CitaDTO> buscarCitaPorIdPacienteConLimite(String idPaciente, int maxLimit) {
        List<Cita> citas = citaRepository.findAllByIdPacienteOrderByFechaCitaConLimite(idPaciente, maxLimit);
        List<CitaDTO> citasDto = mapeadorCita.mapearCitaACitaDTO(citas);
        return citasDto;
    }

    @Override
    public List<CitaDTO> buscarCitaPorIdMedicoFecha(String idMedico, LocalDate fechaCita) {
    String query = "FROM Cita WHERE idMedico = :idmedico AND fechaCita = :fechacita";
    return entityManager.createQuery(query)
        .setParameter("idmedico", idMedico)
        .setParameter("fechacita", fechaCita)
        .getResultList();
    }
}
