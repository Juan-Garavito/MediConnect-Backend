package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.TipoSangre;
import com.uis.MediConnect.Repository.TipoSangreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSangreService implements ITipoSangreService{

    private final TipoSangreRepository tipoSangreRepository;

    @Autowired
    public TipoSangreService(TipoSangreRepository tipoSangreRepository) {
        this.tipoSangreRepository = tipoSangreRepository;
    }


    @Override
    public TipoSangre buscarTipoSangrePorId(Integer idsangre) {
        return tipoSangreRepository.findById(idsangre).orElse(null);
    }
}
