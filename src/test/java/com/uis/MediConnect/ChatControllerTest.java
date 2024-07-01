package com.uis.MediConnect;

import com.uis.MediConnect.Controller.ChatController;
import com.uis.MediConnect.Model.Mensaje;
import com.uis.MediConnect.Service.MensajeService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChatControllerTest {


    @InjectMocks
    private ChatController chatController;

    @LocalServerPort
    private int port;

    private WebSocketStompClient stompClient;

    @Mock
    private MensajeService mensajeService;

    private BlockingQueue<Mensaje> blockingQueue;


    @BeforeEach
    public void setup() {
        this.stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        this.blockingQueue = new LinkedBlockingQueue<>();
    }

    @Test
    @Order(1)
    public void obtenerMensajesPorChatId() throws ParseException {
        String idChat = "729431d2-8";
        int pagina = 0;
        List<Mensaje> mensajes = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = sdf.parse("2024-06-30T18:01");
        mensajes.add(new Mensaje("fsaf32qrg", "Hola, doctor", date, "729431d2-8", "1005546504", "1002628745"));
        mensajes.add(new Mensaje("asffagag", "Hola, paciente", date, "729431d2-8", "1002628745", "1005546504"));
        System.out.println(mensajes);
        Mockito.when(mensajeService.obtenerMensajesPorIdChat(anyString(), anyInt())).thenReturn(mensajes);

        ResponseEntity<List<Mensaje>> responseEntity = chatController.obtenerMensjaesPorChatId(idChat, pagina);


        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(mensajes, responseEntity.getBody());
        System.out.println("Codigo respuesta: " + responseEntity.getStatusCode());
        System.out.println("Mensajes obtenidos: " + responseEntity.getBody());
    }


    @Test
    @Order(2)
    public void enviarMensajeChat() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = sdf.parse("2024-06-30T18:01");
        Mensaje mensaje = new Mensaje("fsaf32qrg", "Hola, doctor", date, "729431d2-8", "1005546504", "1002628745");
        chatController.enviarMensaje(mensaje);

        Mockito.verify(mensajeService).guardarMensaje(any(Mensaje.class));
    }

    @Test
    @Order(3)
    public void recibirMensaje() throws Exception {
        StompSession session = stompClient.connect("ws://localhost:" + port + "/chats", new WebSocketHttpHeaders(), new StompSessionHandlerAdapter() {}).get();

        session.subscribe("/chat/729431d2-8", new StompSessionHandlerAdapter() {
            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                blockingQueue.offer((Mensaje) payload);
            }

            @Override
            public Type getPayloadType(StompHeaders headers) {
                return Mensaje.class;
            }
        });

        Mensaje mensaje = new Mensaje("asfafsf", "Hola, doctor", new Date(), "729431d2-8", "1005546504", "1002628745");
        mensajeService.guardarMensaje(mensaje);

        session.send("/chat/729431d2-8", mensaje);

        Mensaje mensajeRecibido = blockingQueue.poll(5, TimeUnit.SECONDS);
        Assertions.assertEquals(mensaje.getContenido(), mensajeRecibido.getContenido());
        System.out.println("Mensaje enviado: " + mensaje.getContenido());
        System.out.println("Mensaje recibido: " + mensajeRecibido.getContenido());
    }

}
