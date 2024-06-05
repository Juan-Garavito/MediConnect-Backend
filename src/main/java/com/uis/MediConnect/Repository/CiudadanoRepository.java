package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.Ciudadano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadanoRepository extends JpaRepository<Ciudadano, String> {

    Ciudadano findByCorreoAndPassword(String correo, String password);
}
