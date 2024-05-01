package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, String> {

}
