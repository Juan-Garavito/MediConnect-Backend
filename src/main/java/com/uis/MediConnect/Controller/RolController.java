package com.uis.MediConnect.Controller;


import com.uis.MediConnect.Model.Rol;
import com.uis.MediConnect.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/rolciudadano")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }


    @GetMapping("/buscar/{idrol}")
    public Rol buscarTodosRolCiudadano(@PathVariable Integer idrol){
        return rolService.buscarTodosRolCiudadano(idrol);
    }

}
