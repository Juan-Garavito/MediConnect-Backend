package com.uis.MediConnect.Service;


import com.uis.MediConnect.Model.Rol;
import com.uis.MediConnect.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RolService implements IRolService {

    private final RolRepository rolRepository;


    @Autowired
    public RolService(RolRepository rolRepository, GeneroService generoService, TipoSangreService tipoSangreService) {
        this.rolRepository = rolRepository;
    }

    @Override
    public Rol buscarTodosRolCiudadano(Integer idrol) {
        return rolRepository.findById(idrol).orElse(null);

    }
}
