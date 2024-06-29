package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.Mensaje;
import com.uis.MediConnect.Service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/chat/{idChat}/{pagina}")
    public ResponseEntity<List<Mensaje>> obtenerMensjaesPorChatId(@PathVariable String idChat, @PathVariable  int pagina){
        System.out.println("Llego: "+ idChat + " " + pagina);
        List<Mensaje> mensajes =  mensajeService.obtenerMensajesPorIdChat(idChat,pagina);
        System.out.println("Llego: "+ mensajes.toString());

        if(!mensajes.isEmpty()){
            return new ResponseEntity<>(mensajes, HttpStatus.OK);
        }
        System.out.println("Llego: "+ "vacio");
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}

