package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.OrdenTratamiento;
import com.uis.MediConnect.Service.OrdenTratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ordentratamiento")
public class OrdenTratamientoController {

    private final OrdenTratamientoService ordenTratamientoService;

    @Autowired
    public OrdenTratamientoController(OrdenTratamientoService ordenTratamientoService) {
        this.ordenTratamientoService = ordenTratamientoService;
    }

    @PostMapping("/ingresar")
    ResponseEntity<OrdenTratamiento> ingresarOrdenTratamiento(@RequestBody OrdenTratamiento orden){
        OrdenTratamiento ordenTratamiento = ordenTratamientoService.buscarOrdenTratamiento(orden.getIdOrdenTratamineto());
        if (orden != null && ordenTratamiento == null){
            ordenTratamientoService.guardarOrdenTratamiento(orden);
            return new ResponseEntity<>(orden, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{idOrden}")
    ResponseEntity<OrdenTratamiento> buscarOrdenTratameinto(@PathVariable String idOrden){
        OrdenTratamiento orden = ordenTratamientoService.buscarOrdenTratamiento(idOrden);
        if(orden != null){
            return new ResponseEntity<>(orden, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar")
    ResponseEntity<List<OrdenTratamiento>> buscarTodasOrdenTratameinto(){
        List<OrdenTratamiento> ordenes = ordenTratamientoService.buscarTodasOrdenTratamiento();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    @PutMapping("/editar")
    ResponseEntity<OrdenTratamiento> editarOrdenTratamiento(@RequestBody  OrdenTratamiento orden){
        OrdenTratamiento ordenEditada = ordenTratamientoService.editarOrdenTratamiento(orden);
        if (ordenEditada != null){
            return new ResponseEntity<>(ordenEditada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{idOrden}")
    ResponseEntity<OrdenTratamiento> editarOrdenTratamiento(@PathVariable String idOrden){
        OrdenTratamiento orden = ordenTratamientoService.eliminarOrdenTratamiento(idOrden);
        if (orden != null){
            return new ResponseEntity<>(orden, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
