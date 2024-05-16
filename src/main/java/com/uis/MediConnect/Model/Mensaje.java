package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "mensaje")
public class Mensaje {

    @Id
    @Column(name = "idmensaje")
    private String idMensaje;
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "fechamensaje")
    private Date fechaMensaje;
    @Column(name = "idchat")
    private String idChat;
    @Column(name = "idremitente")
    private String idRemitente;
    @Column(name = "iddestinatario")
    private String idDestinatario;

    public Mensaje() {
    }

    public Mensaje(String idMensaje, String contenido, Date fechaMensaje, String idChat, String idRemitente, String idDestinatario) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.fechaMensaje = fechaMensaje;
        this.idChat = idChat;
        this.idRemitente = idRemitente;
        this.idDestinatario = idDestinatario;
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Date fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(String idDestinatario) {
        this.idDestinatario = idDestinatario;
    }


}
