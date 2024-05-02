package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Ciudadano;
import com.uis.MediConnect.Repository.CiudadanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CiudadanoService implements ICiudadanoService{

    private final CiudadanoRepository ciudadanoRepository;

    @Autowired
    public CiudadanoService(CiudadanoRepository ciudadanoRepository) {
        this.ciudadanoRepository = ciudadanoRepository;
    }


    @Override
    public Ciudadano guardarCiudadano(Ciudadano ciudadano) {
        return ciudadanoRepository.save(ciudadano);
    }

    @Override
    public Ciudadano buscarCiudadano(String idCiudadano) {
        return ciudadanoRepository.findById(idCiudadano).orElse(null);
    }

    @Override
    public List<Ciudadano> buscarTodasCiudadano() {
        return ciudadanoRepository.findAll();
    }

    @Override
    public Ciudadano editarCiudadano(Ciudadano ciudadano) {
        Ciudadano oldCiudadano = buscarCiudadano(ciudadano.getNumerodocumento());
        if(oldCiudadano != null){
            return guardarCiudadano(ciudadano);
        }
        return oldCiudadano;
    }

    @Override
    public Ciudadano eliminarCiudadano(String idCiudadano) {
        Ciudadano ciudadano = buscarCiudadano(idCiudadano);
        if(ciudadano != null){
            ciudadanoRepository.deleteById(idCiudadano);
            return ciudadano;
        }
        return null;
    }
}
