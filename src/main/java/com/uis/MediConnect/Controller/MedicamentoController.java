package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.Medicamento;
import com.uis.MediConnect.Service.MedicamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicamento")
public class MedicamentoController {
    
    @Autowired
    MedicamentoService medicamentoService;
    
    @GetMapping("/list")
    public List<Medicamento> cargarMedicamentos(){
        return medicamentoService.getMedicamentos();
    }
}
