package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.Cita;
import com.uis.MediConnect.Model.Ciudadano;
import com.uis.MediConnect.Model.FormulaMedica;
import com.uis.MediConnect.Service.FormulaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/formulamedica")
public class FormulaMedicaController {

    private FormulaMedicaService formulaMedicaService;

    @Autowired
    public FormulaMedicaController(FormulaMedicaService formulaMedicaService) {
        this.formulaMedicaService = formulaMedicaService;
    }

    @PostMapping("/ingresar")
    ResponseEntity<FormulaMedica> ingresarFormulaMedica(@RequestBody FormulaMedica formula){
        FormulaMedica formulaMedica = formulaMedicaService.buscarFormulaMedica(formula.getIdFormulaMedica());
        if(formula != null && formulaMedica == null){
            formulaMedicaService.guardarFormulaMedica(formula);
            return new ResponseEntity<>(formula, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/{idFormula}")
    ResponseEntity<FormulaMedica> buscarFormulaMedica(@PathVariable String idFormula){
        FormulaMedica formulaMedica = formulaMedicaService.buscarFormulaMedica(idFormula);
        if(formulaMedica != null){
            return new ResponseEntity<>(formulaMedica, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar")
    ResponseEntity<List<FormulaMedica>> buscarTodasFormulaMedica(){
        return new ResponseEntity<>(formulaMedicaService.buscarTodasFormulaMedica(), HttpStatus.OK);
    }

    @PutMapping("/editar")
    ResponseEntity<FormulaMedica> editarFormulaMedica(@RequestBody FormulaMedica formula){
        FormulaMedica formulaMedica = formulaMedicaService.editarFormulaMedica(formula);
        if(formulaMedica != null){
            return new ResponseEntity<>(formulaMedica, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar/{idFormula}")
    ResponseEntity<FormulaMedica> eliminarFormulaMedica(@PathVariable String idFormula){
        if(!idFormula.isEmpty()){
            FormulaMedica formulaMedica = formulaMedicaService.eliminarFormulaMedica(idFormula);
            return new ResponseEntity<>(formulaMedica, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
