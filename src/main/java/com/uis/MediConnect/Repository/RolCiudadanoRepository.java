package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.RolCiudadano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RolCiudadanoRepository extends JpaRepository<RolCiudadano, Integer> {
        RolCiudadano findByNumeroDocumento(String numerodocumento);
}
