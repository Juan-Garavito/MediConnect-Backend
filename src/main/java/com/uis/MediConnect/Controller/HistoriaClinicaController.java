package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.Cita;
import com.uis.MediConnect.Model.HistoriaClinica;
import com.uis.MediConnect.Service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/historiaclinica")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    @Autowired
    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }


    @PostMapping("/ingresar")
    ResponseEntity<HistoriaClinica> guardarHistoriaClinica(@RequestBody HistoriaClinica historia){
        HistoriaClinica historiaClinica = historiaClinicaService.buscarHistoriaClinica(historia.getIdHistoriaClinica());
        if(historia != null && historiaClinica  == null){
            historiaClinicaService.guardarHistoriaClinica(historia);
            return new ResponseEntity<>(historia, HttpStatus.CREATED);
        }
        return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/{idHistoria}")
    ResponseEntity<HistoriaClinica> buscarHistoriaClinica(@PathVariable String idHistoria){
        HistoriaClinica historiaClinica = historiaClinicaService.buscarHistoriaClinica(idHistoria);
        if(historiaClinica != null){
            return new ResponseEntity<>(historiaClinica, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar")
    ResponseEntity<List<HistoriaClinica>> buscarTodasHistoriaClinica(){
        return new ResponseEntity<>(historiaClinicaService.buscarTodasHistoriaClinica(), HttpStatus.OK);
    }

    @PutMapping("/editar")
    ResponseEntity<HistoriaClinica> editarHistoriaClinica(@RequestBody HistoriaClinica historia){
        HistoriaClinica historiaClinica = historiaClinicaService.editarHistoriaClinica(historia);
        if(historiaClinica != null ){
            return new ResponseEntity<>(historiaClinica, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar/{idHistoria}")
    ResponseEntity<HistoriaClinica> eliminarHistoriaClinica(@PathVariable String idHistoria){
        HistoriaClinica historiaClinica = historiaClinicaService.eliminarHistoriaClinica(idHistoria);
        if(historiaClinica != null){
            return new ResponseEntity<>(historiaClinica, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
