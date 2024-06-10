package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.Mensaje;
import com.uis.MediConnect.Service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
public class ChatController {

    private final MensajeService mensajeService;

    public ChatController(MensajeService mensajeService, SimpUserRegistry simpUserRegistry) {
        this.mensajeService = mensajeService;
    }

    @MessageMapping("/{idchat}")
    @SendTo("/chat/{idchat}")
    public void enviarMensaje(@Payload Mensaje mensaje) {
        mensajeService.guardarMensaje(mensaje);
        System.out.println("Mensaje: " + mensaje);
    }

    @GetMapping("/chat/{idChat}")
    public List<Mensaje> obtenerMensjaesPorChatId(@PathVariable String idChat){
        List<Mensaje> mensajes =  mensajeService.obtenerMensajesPorIdChat(idChat);
        System.out.println("Llego: "+ mensajes.toString());
        return mensajes;
    }

}

