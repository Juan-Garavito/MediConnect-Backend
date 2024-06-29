package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Mensaje;
import com.uis.MediConnect.Repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MensajeService implements IMensajeService{

    private final MensajeRepository mensajeRepository;

    @Autowired
    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }


    @Override
    public Mensaje guardarMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    @Override
    public List<Mensaje> obtenerMensajesPorIdChat(String idchat, int pagina){
        Pageable pageable = PageRequest.of(pagina, 20);
        return mensajeRepository.findAllByIdChatOrderByFechaMensajeDesc(idchat, pageable);
    }
}
