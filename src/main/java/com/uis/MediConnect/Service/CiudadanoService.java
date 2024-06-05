package com.uis.MediConnect.Service;

import com.uis.MediConnect.DTO.CiudadanoDTO;
import com.uis.MediConnect.Model.Ciudadano;
import com.uis.MediConnect.Model.Rol;
import com.uis.MediConnect.Repository.CiudadanoRepository;
import com.uis.MediConnect.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CiudadanoService implements ICiudadanoService{

    private final CiudadanoRepository ciudadanoRepository;
    private final RolRepository rolRepository;

    @Autowired
    public CiudadanoService(CiudadanoRepository ciudadanoRepository, RolRepository rolRepository) {
        this.ciudadanoRepository = ciudadanoRepository;
        this.rolRepository = rolRepository;
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

    @Override
    public CiudadanoDTO loginCiudadano(String contraseña, String correo) {
        Ciudadano ciudadano = ciudadanoRepository.findByCorreoAndPassword(correo, contraseña);
        if(ciudadano != null){
            List<Rol> rolLista = rolRepository.findAll();
            int i;
            for(i=0; i<rolLista.size();i++){
                if(rolLista.get(i).getCiudadanos().contains(ciudadano)){
                    break;
                };
            }
            CiudadanoDTO ciudadanoDTO = new CiudadanoDTO(ciudadano.getNumerodocumento(),
                    ciudadano.getNombres(),
                    ciudadano.getApellidos(),
                    ciudadano.getUrlimagenperfil(),
                    rolLista.get(i).getIdRol());
            System.out.println(ciudadanoDTO.toString());
            return ciudadanoDTO;

        }
        return null;                                        
    }
}
