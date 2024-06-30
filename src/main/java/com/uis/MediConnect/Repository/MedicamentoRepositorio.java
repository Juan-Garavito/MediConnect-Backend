package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepositorio extends JpaRepository<Medicamento, Long> {
    
}
