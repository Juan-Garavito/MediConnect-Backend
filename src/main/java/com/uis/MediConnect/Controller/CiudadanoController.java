package com.uis.MediConnect.Controller;


import com.google.common.hash.Hashing;
import com.uis.MediConnect.Config.AESEncryption;
import com.uis.MediConnect.DTO.CiudadanoDTO;
import com.uis.MediConnect.DTO.LoginDTO;
import com.uis.MediConnect.Model.Ciudadano;
import com.uis.MediConnect.Service.CiudadanoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ciudadano")
public class CiudadanoController {


    private final CiudadanoService ciudadanoService;
    private AESEncryption aesEncryption;

    @Autowired
    public CiudadanoController(CiudadanoService ciudadanoService, AESEncryption aesEncryption) {
        this.ciudadanoService = ciudadanoService;
        this.aesEncryption = aesEncryption;
    }

    @PostMapping({"/ingresar", "/ingresar/{idRol}"})
    ResponseEntity<Ciudadano> guardarCiudadano(@Valid @RequestBody Ciudadano ciudadano, @PathVariable(required = false) Integer idRol){
        Ciudadano ciudadanoPrueba = ciudadanoService.buscarCiudadano(ciudadano.getNumerodocumento());
        if(ciudadano != null && ciudadanoPrueba == null){
            ciudadanoService.guardarCiudadano(ciudadano, idRol);
            return new ResponseEntity<>(ciudadano, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(ciudadano, HttpStatus.NOT_FOUND );
    }

    @GetMapping("/buscar/{idCiudadano}")
    ResponseEntity<Ciudadano> buscarCiudadano(@PathVariable String idCiudadano){
        Ciudadano ciudadano = ciudadanoService.buscarCiudadano(idCiudadano);
        if(ciudadano != null){
            return new ResponseEntity<>(ciudadano, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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

       return new ResponseEntity<>(ciudadano, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{idCiudadano}")
    ResponseEntity<Ciudadano> eliminarCiudadano(@PathVariable String idCiudadano){
        if(!idCiudadano.isEmpty()){
            Ciudadano ciudadano = ciudadanoService.eliminarCiudadano(idCiudadano);
            return new ResponseEntity<>(ciudadano, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/login")
    ResponseEntity<CiudadanoDTO> loginCiudadano(@Valid @RequestBody LoginDTO login) throws Exception {
        CiudadanoDTO ciudadano = ciudadanoService.loginCiudadano(login.getContraseña(),login.getCorreo());
        if(ciudadano != null){
            return new ResponseEntity<>(ciudadano, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> respuestaErrorConLaPeticion(MethodArgumentNotValidException error){
        HashMap<String, String> response = new HashMap<>();
        error.getAllErrors().forEach(e -> {
            String mensajeError = e.getDefaultMessage();
            String celda = ((FieldError) e).getField();
            response.put(celda, mensajeError);
        });
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
