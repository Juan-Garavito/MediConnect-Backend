package com.uis.MediConnect.Service;

import com.google.common.hash.Hashing;
import com.uis.MediConnect.Config.AESEncryption;
import com.uis.MediConnect.DTO.CiudadanoDTO;
import com.uis.MediConnect.Model.Ciudadano;
import com.uis.MediConnect.Model.Rol;
import com.uis.MediConnect.Repository.CiudadanoRepository;
import com.uis.MediConnect.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
@Transactional
public class CiudadanoService implements ICiudadanoService{

    private final CiudadanoRepository ciudadanoRepository;
    private final RolRepository rolRepository;
    private final AESEncryption aesEncryption;

    @Autowired
    public CiudadanoService(CiudadanoRepository ciudadanoRepository, RolRepository rolRepository, AESEncryption aesEncryption) {
        this.ciudadanoRepository = ciudadanoRepository;
        this.rolRepository = rolRepository;
        this.aesEncryption = aesEncryption;
    }


    @Override
    public Ciudadano guardarCiudadano(Ciudadano ciudadano) {
        String contraseñaEncryptada = null;
        try {
            contraseñaEncryptada = aesEncryption.cifrar(ciudadano.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ciudadano.setPassword(contraseñaEncryptada);
        System.out.println(contraseñaEncryptada);
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
        Ciudadano ciudadano = ciudadanoRepository.findByCorreo(correo);
        if(ciudadano != null){
            String contraseñaEncryptada = null ;
            try {
                contraseñaEncryptada = aesEncryption.cifrar(contraseña);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(contraseñaEncryptada);
            System.out.println(ciudadano.getPassword());
            if(ciudadano.getPassword().equals(contraseñaEncryptada)){
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
                    return ciudadanoDTO;
            }

        }
        return null;                                        
    }
}
