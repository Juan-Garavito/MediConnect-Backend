package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Chat;
import com.uis.MediConnect.Model.Cita;
import com.uis.MediConnect.Repository.ChatRepository;
import com.uis.MediConnect.Repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@EnableScheduling
public class ChatService implements IChatService{

    private final CitaRepository citaRepository;
    private final ChatRepository chatRepository;

    @Autowired
    public ChatService(CitaRepository citaRepository, ChatRepository chatRepository) {
        this.citaRepository = citaRepository;
        this.chatRepository = chatRepository;
    }


    @Scheduled(cron = "0 0 1 * * *", zone = "America/Bogota")
    @Override
    public void crearIdChat() {
        List<Cita> citas = citaRepository.findAll();
        Integer idCitaRemota = 2;
        if(!citas.isEmpty()){
            List<Cita> citasVirtuales = citas.stream().filter(cita->cita.getIdModalidadCita().equals(idCitaRemota) & cita.getFechaCita().equals(LocalDate.now())).collect(Collectors.toList());
            for(Cita cita : citasVirtuales) {
                String idChat = UUID.randomUUID().toString().substring(0,10);

                Chat nuevoChat = new Chat(idChat, cita.getIdCita());
                guardarChat(nuevoChat);
            }

        }

        System.out.println("Se ejecuto");
    }

    @Override
    public void guardarChat(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public Chat obtenerChatPorIdCita(String idCita) {
        return chatRepository.findByIdCita(idCita);
    }

}
