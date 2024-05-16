package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.Mensaje;
import com.uis.MediConnect.Service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
public class ChatController {

    private final MensajeService mensajeService;

    @Autowired
    public ChatController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }


    @MessageMapping("/{idchat}")
    @SendTo("/chat/{idchat}")
    public void enviarMensaje(Mensaje mensaje) {
        mensajeService.guardarMensaje(mensaje);
        System.out.println("Mensaje: " + mensaje.toString());
    }

    @GetMapping("/chat/{idChat}")
    public List<Mensaje> obtenerMensjaesPorChatId(@PathVariable String idChat){
        return mensajeService.obtenerMensajesPorIdChat(idChat);
    }


}
