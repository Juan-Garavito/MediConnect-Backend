package com.uis.MediConnect.Controller;

import com.uis.MediConnect.DTO.CitaDTO;
import com.uis.MediConnect.Model.*;
import com.uis.MediConnect.Repository.DisponibilidadMedicoRepository;
import com.uis.MediConnect.Repository.EspecialidadRepository;
import com.uis.MediConnect.Repository.IpsRepository;
import com.uis.MediConnect.Repository.ModalidadCitaRepository;
import com.uis.MediConnect.Service.ChatService;
import com.uis.MediConnect.Service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;
    private final DisponibilidadMedicoRepository disponibilidadMedicoRepository;
    private final EspecialidadRepository especialidadRepository;
    private final ModalidadCitaRepository modalidadCitaRepository;
    private  final IpsRepository ipsRepository;


    @Autowired
    public CitaController(CitaService citaService, ChatService chatService, DisponibilidadMedicoRepository disponibilidadMedicoRepository, EspecialidadRepository especialidadRepository, ModalidadCitaRepository modalidadCitaRepository, IpsRepository ipsRepository) {
        this.citaService = citaService;
        this.disponibilidadMedicoRepository = disponibilidadMedicoRepository;
        this.especialidadRepository = especialidadRepository;
        this.modalidadCitaRepository = modalidadCitaRepository;
        this.ipsRepository = ipsRepository;
    }


    @PostMapping("/ingresar")
    ResponseEntity<Cita> guardarCita(@RequestBody Cita cita){
        Cita citaPrueba = citaService.buscarCita(cita.getIdCita());
        System.out.println("Cita nueva");
        if(cita != null && citaPrueba  == null){
            citaService.guardarCita(cita);
            return new ResponseEntity<>(cita, HttpStatus.CREATED);
        }
        return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/{idCita}")
    ResponseEntity<Cita> buscarCita(@PathVariable String idCita){
        Cita cita = citaService.buscarCita(idCita);
        System.out.println("Cita buscada " + cita.getIdCita());
        if(cita != null){
            return new ResponseEntity<>(cita, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar")
    ResponseEntity<List<Cita>> buscarTodasCitas(){
        return new ResponseEntity<>(citaService.buscarTodasCitas(), HttpStatus.OK);
    }

    @PutMapping("/editar")
    ResponseEntity<Cita> editarCita(@RequestBody Cita cita){
        Cita citaEditada = citaService.editarCita(cita);
        if(citaEditada != null ){
            return new ResponseEntity<>(citaEditada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar/{idCita}")
    ResponseEntity<Cita> eliminarCita(@PathVariable String idCita){
        Cita cita = citaService.eliminarCita(idCita);
        System.out.println("elimino "+ cita.getIdCita());
        if(cita != null){
            return new ResponseEntity<>(cita, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

<<<<<<< Updated upstream
    //Solicitud para obtener las citas asociadas a un paciente
=======
>>>>>>> Stashed changes
    @GetMapping("/buscar/paciente/{idPaciente}")
    ResponseEntity<List<CitaDTO>> buscarCitaPorIdPaciente(@PathVariable String idPaciente){
        List<CitaDTO> citas = citaService.buscarCitaPorIdPaciente(idPaciente);

        if(!citas.isEmpty()){
            return new ResponseEntity<>(citas, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
<<<<<<< Updated upstream
    
    //Solicitud para obtener las citas asociadas a un médico
    @GetMapping("/buscar/medico/{idmedico}")
    ResponseEntity<List<CitaDTO>> buscarCitaPorIdMedico(@PathVariable String idmedico){
        List<CitaDTO> citas = citaService.buscarCitaPorIdMedico(idmedico);
=======


    @GetMapping("/buscar/paciente/{idPaciente}/{maxLimit}")
    ResponseEntity<List<CitaDTO>> buscarCitaPorIdPacienteConLimite(@PathVariable String idPaciente, @PathVariable int maxLimit){
        List<CitaDTO> citas = citaService.buscarCitaPorIdPacienteConLimite(idPaciente, maxLimit);
>>>>>>> Stashed changes

        if(!citas.isEmpty()){
            return new ResponseEntity<>(citas, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
<<<<<<< Updated upstream
    
    
=======

    @GetMapping("/buscar/medicos/{fecha}/{idEspecialidad}")
    ResponseEntity<List<Ciudadano>> buscarDisponibilidadMedicoPorFecha(@PathVariable LocalDate fecha, @PathVariable Integer idEspecialidad){
        List<DisponibilidadMedico> disponibilidadMedicos = disponibilidadMedicoRepository.findAllByFechaAndEstado(fecha, false);
        Especialidad especialidad = especialidadRepository.findById(idEspecialidad).orElse(null);
        List<Ciudadano> especialidadCiudadanos = especialidad.getCiudadanos();

        List<Ciudadano> medicos = new ArrayList<>();

        for (DisponibilidadMedico disponibilidadMedico : disponibilidadMedicos){
            if(medicos.contains(disponibilidadMedico.getIdMedico())){
                continue;
            }

           if(especialidadCiudadanos.contains(disponibilidadMedico.getIdMedico())){
               medicos.add(disponibilidadMedico.getIdMedico());
           }
        }

        System.out.println("medico");


        if(!medicos.isEmpty()){
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/medicos/franjahoraria/{idMedico}")
    ResponseEntity<List<FranjaHoraria>> buscarFranjaHorariaPorIdMedico(@PathVariable String idMedico){
        List<DisponibilidadMedico> disponibilidadMedicos = disponibilidadMedicoRepository.findAllByIdMedico(idMedico);
        List<FranjaHoraria> franjaHorariasMedico = new ArrayList<>();

        for(DisponibilidadMedico disponibilidadMedico : disponibilidadMedicos){
            franjaHorariasMedico.add(disponibilidadMedico.getIdFranjaHoraria());
        }

        System.out.println("franja horaria");
        if(!disponibilidadMedicos.isEmpty()){
            return new ResponseEntity<>(franjaHorariasMedico, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/modalidadcita")
    ResponseEntity<List<ModalidadCita>> buscarTodasModalidadCita(){
        List<ModalidadCita> modalidadesCitas = modalidadCitaRepository.findAll();

        System.out.println("modalidad cita");   
        if(!modalidadesCitas.isEmpty()){
            return new ResponseEntity<>(modalidadesCitas, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/especialidades")
    ResponseEntity<List<Especialidad>> buscarTodasEspecialidades(){
        List<Especialidad> especialidades = especialidadRepository.findAll();
        System.out.println("especialidad");
        if(!especialidades.isEmpty()){
            return new ResponseEntity<>(especialidades, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/listIps")
    ResponseEntity<List<Ips>> buscarTodasIps(){
        List<Ips> listIps = ipsRepository.findAll();
        System.out.println("ips");
        if(!listIps.isEmpty()){
            return new ResponseEntity<>(listIps, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
>>>>>>> Stashed changes
}
