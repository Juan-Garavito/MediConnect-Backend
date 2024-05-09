package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.TipoSangre;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ITipoSangreService {

    TipoSangre buscarTipoSangrePorId(Integer idsangre);
}
