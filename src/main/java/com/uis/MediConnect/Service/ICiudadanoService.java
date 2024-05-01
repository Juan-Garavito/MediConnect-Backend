package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Ciudadano;

public interface ICiudadanoService {

    Ciudadano guardarCiudadano(Ciudadano ciudadano);
    Ciudadano buscarCiudadano(String idCiudadano);
    Ciudadano editarCiudadano(Ciudadano ciudadano);
    Ciudadano eliminarCiudadano(String idCiudadano);

}
