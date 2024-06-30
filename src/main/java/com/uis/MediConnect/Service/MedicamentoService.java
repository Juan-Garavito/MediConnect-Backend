package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Medicamento;
import com.uis.MediConnect.Repository.MedicamentoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MedicamentoService implements IMedicamentoService {   
    
    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;

    @Override
    public List<Medicamento> getMedicamentos() {
        return  medicamentoRepositorio.findAll();
    }
    
}
