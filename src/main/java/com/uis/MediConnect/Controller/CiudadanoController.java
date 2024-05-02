package com.uis.MediConnect.Controller;


import com.uis.MediConnect.Model.Ciudadano;
import com.uis.MediConnect.Service.CiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ciudadano")
public class CiudadanoController {


    private final CiudadanoService ciudadanoService;

    @Autowired
    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    @PostMapping("/ingresar")
    ResponseEntity<Ciudadano> guardarCiudadano(@RequestBody Ciudadano ciudadano){
        Ciudadano ciudadanoPrueba = ciudadanoService.buscarCiudadano(ciudadano.getNumerodocumento());
        if(ciudadano != null && ciudadanoPrueba == null){
            ciudadanoService.guardarCiudadano(ciudadano);
            return new ResponseEntity<>(ciudadano, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(ciudadano, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/{idCiudadano}")
    ResponseEntity<Ciudadano> buscarCiudadano(@PathVariable String idCiudadano){
        Ciudadano ciudadano = ciudadanoService.buscarCiudadano(idCiudadano);
        if(ciudadano != null){
            return new ResponseEntity<>(ciudadano, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar")
    ResponseEntity<List<Ciudadano>> buscarTodasCiudadano(){
        return new ResponseEntity<>(ciudadanoService.buscarTodasCiudadano(), HttpStatus.OK);
    }

    @PutMapping("/editar")
    ResponseEntity<Ciudadano> editarCiudadano(@RequestBody Ciudadano ciudadano){
       Ciudadano cd = ciudadanoService.editarCiudadano(ciudadano);
       if(cd != null){
           return new ResponseEntity<>(ciudadano, HttpStatus.CREATED);
       }

       return new ResponseEntity<>(ciudadano, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar/{idCiudadano}")
    ResponseEntity<Ciudadano> eliminarCiudadano(@PathVariable String idCiudadano){
        if(!idCiudadano.isEmpty()){
            Ciudadano ciudadano = ciudadanoService.eliminarCiudadano(idCiudadano);
            return new ResponseEntity<>(ciudadano, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
