package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.FormulaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaMedicaRepository extends JpaRepository<FormulaMedica, String> {
}
