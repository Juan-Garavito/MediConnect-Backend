package com.uis.MediConnect.DTO;

import java.time.LocalDate;

public class CitaDTO {

    private String idCita;
    private LocalDate fechaCita;
    private String franjaHoraria;
    private String especialidad;
    private String modalidadCita;
    private String idPaciente;
    private String medico;
    private String ips;
    private String urlIps;
    private String idChat;

    public CitaDTO() {
    }

    public CitaDTO(String idCita, LocalDate fechaCita, String franjaHoraria, String especialidad, String modalidadCita, String idPaciente, String medico, String ips, String urlIps, String idChat) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.franjaHoraria = franjaHoraria;
        this.especialidad = especialidad;
        this.modalidadCita = modalidadCita;
        this.idPaciente = idPaciente;
        this.medico = medico;
        this.ips = ips;
        this.urlIps = urlIps;
        this.idChat = idChat;
    }

    public CitaDTO(Builder builder) {
        this.idCita = builder.idCita;
        this.fechaCita = builder.fechaCita;
        this.franjaHoraria = builder.idFranjaHoraria;
        this.especialidad = builder.idEspecialidad;
        this.modalidadCita = builder.idModalidadCita;
        this.idPaciente = builder.idPaciente;
        this.medico = builder.idMedico;
        this.ips = builder.idIps;
        this.idChat = builder.idChat;
        this.urlIps = builder.urlIps;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public void setFranjaHoraria(String franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setModalidadCita(String modalidadCita) {
        this.modalidadCita = modalidadCita;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public void setUrlIps(String urlIps) {
        this.urlIps = urlIps;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }
    
    public String getIdCita() {
        return idCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getModalidadCita() {
        return modalidadCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getMedico() {
        return medico;
    }

    public String getIps() {
        return ips;
    }

    public String getIdChat() {
        return idChat;
    }

    public String getUrlIps() {
        return urlIps;
    }
    
    

    @Override
    public String toString() {
        return "CitaDTO{" +
                "idCita='" + idCita + '\'' +
                ", fechaCita=" + fechaCita +
                ", franjaHoraria='" + franjaHoraria + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", modalidadCita='" + modalidadCita + '\'' +
                ", idPaciente='" + idPaciente + '\'' +
                ", medico='" + medico + '\'' +
                ", ips='" + ips + '\'' +
                ", idChat='" + idChat + '\'' +
                '}';
    }

    public static class Builder  {
        public String urlIps;
        private  String idCita;
        private  LocalDate fechaCita;
        private  String idFranjaHoraria;
        private  String idEspecialidad;
        private  String idModalidadCita;
        private  String idPaciente;
        private  String idMedico;
        private  String idIps;
        private  String idChat;

        public CitaDTO.Builder IdCita(String idCita) {
            this.idCita = idCita;
            return this;
        }

        public CitaDTO.Builder  FechaCita(LocalDate fechaCita) {
            this.fechaCita = fechaCita;
            return this;
        }

        public CitaDTO.Builder  FranjaHoraria(String idFranjaHoraria) {
            this.idFranjaHoraria = idFranjaHoraria;
              return this;
        }

        public CitaDTO.Builder  Especialidad(String idEspecialidad) {
            this.idEspecialidad = idEspecialidad;
            return this;
        }

        public CitaDTO.Builder  ModalidadCita(String idModalidadCita) {
            this.idModalidadCita = idModalidadCita;
            return this;
        }

        public CitaDTO.Builder  IdPaciente(String idPaciente) {
            this.idPaciente = idPaciente;
            return this;
        }

        public CitaDTO.Builder Medico(String idMedico) {
            this.idMedico = idMedico;
            return this;
        }

        public CitaDTO.Builder Ips(String idIps) {
            this.idIps = idIps;
            return this;
        }

        public CitaDTO.Builder urlIps(String urlIps) {
            this.urlIps = urlIps;
            return this;
        }

        public CitaDTO.Builder  IdChat(String idChat) {
            this.idChat = idChat;
            return this;
        }

        public CitaDTO build(){
            return new CitaDTO(this);
        }
    }
}
