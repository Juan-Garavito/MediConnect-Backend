package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Chat;


public interface IChatService {
    void crearIdChat(String idCita);

    void guardarChat(Chat Chat);

    Chat obtenerChatPorIdCita(String idCita);
}
