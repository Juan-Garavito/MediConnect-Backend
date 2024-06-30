package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Config.AESEncryption;
import com.uis.MediConnect.Model.Mensaje;
import com.uis.MediConnect.Service.MensajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ChatController(MensajeService mensajeService, SimpUserRegistry simpUserRegistry, AESEncryption aesEncryption, AESEncryption aesEncryption1) {
        this.mensajeService = mensajeService;;
    }

    @MessageMapping("/{idchat}")
    @SendTo("/chat/{idchat}")
    public void enviarMensaje(@Payload Mensaje mensaje)  {
        System.out.println(mensaje);
        mensajeService.guardarMensaje(mensaje);
    }

    @GetMapping("/chat/{idChat}/{pagina}")
    public ResponseEntity<List<Mensaje>> obtenerMensjaesPorChatId(@PathVariable String idChat, @PathVariable  int pagina){
        List<Mensaje> mensajes =  mensajeService.obtenerMensajesPorIdChat(idChat,pagina);
        if(!mensajes.isEmpty()){
            return new ResponseEntity<>(mensajes, HttpStatus.OK);
        }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}

