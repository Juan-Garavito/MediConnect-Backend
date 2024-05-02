package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Ciudadano;

import java.util.List;

public interface ICiudadanoService {

    Ciudadano guardarCiudadano(Ciudadano ciudadano);
    Ciudadano buscarCiudadano(String idCiudadano);
    List<Ciudadano> buscarTodasCiudadano();
    Ciudadano editarCiudadano(Ciudadano ciudadano);
    Ciudadano eliminarCiudadano(String idCiudadano);

}
