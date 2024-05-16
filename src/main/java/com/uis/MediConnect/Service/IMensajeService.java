package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.Mensaje;

import java.util.List;

public interface IMensajeService {
    Mensaje guardarMensaje(Mensaje mensaje);
    List<Mensaje> obtenerMensajesPorIdChat(String idchat);
}
