package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.OrdenTratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenTratamientoRepository extends JpaRepository<OrdenTratamiento, String> {
}
