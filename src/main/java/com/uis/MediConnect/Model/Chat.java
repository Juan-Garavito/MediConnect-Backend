package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @Column(name = "idchat")
    private String idChat;
    @Column(name = "idcita")
    private String idCita;

    public Chat() {
    }

    public Chat(String idChat, String idCita) {
        this.idChat = idChat;
        this.idCita = idCita;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "idChat='" + idChat + '\'' +
                ", idCita='" + idCita + '\'' +
                '}';
    }
}
