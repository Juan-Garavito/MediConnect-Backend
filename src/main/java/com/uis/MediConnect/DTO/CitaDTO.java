package com.uis.MediConnect.DTO;

import java.time.LocalDate;

public class CitaDTO {

    private String idCita;
    private LocalDate fechaCita;
    private Integer idFranjaHoraria;
    private Integer idEspecialidad;
    private Integer idModalidadCita;
    private String idPaciente;
    private String idMedico;
    private Integer idIps;
    private String idChat;

    public CitaDTO() {
    }

    public CitaDTO(String idCita, LocalDate fechaCita, Integer idFranjaHoraria, Integer idEspecialidad, Integer idModalidadCita, String idPaciente, String idMedico, Integer idIps, String idChat) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.idFranjaHoraria = idFranjaHoraria;
        this.idEspecialidad = idEspecialidad;
        this.idModalidadCita = idModalidadCita;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idIps = idIps;
        this.idChat = idChat;
    }

    public CitaDTO(Builder builder) {
        this.idCita = builder.idCita;
        this.fechaCita = builder.fechaCita;
        this.idFranjaHoraria = builder.idFranjaHoraria;
        this.idEspecialidad = builder.idEspecialidad;
        this.idModalidadCita = builder.idModalidadCita;
        this.idPaciente = builder.idPaciente;
        this.idMedico = builder.idMedico;
        this.idIps = builder.idIps;
        this.idChat = builder.idChat;
    }

    public String getIdCita() {
        return idCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public Integer getIdFranjaHoraria() {
        return idFranjaHoraria;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public Integer getIdModalidadCita() {
        return idModalidadCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public Integer getIdIps() {
        return idIps;
    }

    public String getIdChat() {
        return idChat;
    }

    @Override
    public String toString() {
        return "CitaDTO{" +
                "idCita='" + idCita + '\'' +
                ", fechaCita=" + fechaCita +
                ", idFranjaHoraria=" + idFranjaHoraria +
                ", idEspecialidad=" + idEspecialidad +
                ", idModalidadCita=" + idModalidadCita +
                ", idPaciente='" + idPaciente + '\'' +
                ", idMedico='" + idMedico + '\'' +
                ", idIps=" + idIps +
                ", idChat='" + idChat + '\'' +
                '}';
    }

    public static class Builder  {
        private  String idCita;
        private  LocalDate fechaCita;
        private  Integer idFranjaHoraria;
        private  Integer idEspecialidad;
        private  Integer idModalidadCita;
        private  String idPaciente;
        private  String idMedico;
        private  Integer idIps;
        private  String idChat;

        public CitaDTO.Builder IdCita(String idCita) {
            this.idCita = idCita;
            return this;
        }

        public CitaDTO.Builder  FechaCita(LocalDate fechaCita) {
            this.fechaCita = fechaCita;
            return this;
        }

        public CitaDTO.Builder  IdFranjaHoraria(Integer idFranjaHoraria) {
            this.idFranjaHoraria = idFranjaHoraria;
              return this;
        }

        public CitaDTO.Builder  IdEspecialidad(Integer idEspecialidad) {
            this.idEspecialidad = idEspecialidad;
            return this;
        }

        public CitaDTO.Builder  IdModalidadCita(Integer idModalidadCita) {
            this.idModalidadCita = idModalidadCita;
            return this;
        }

        public CitaDTO.Builder  IdPaciente(String idPaciente) {
            this.idPaciente = idPaciente;
            return this;
        }

        public CitaDTO.Builder IdMedico(String idMedico) {
            this.idMedico = idMedico;
            return this;
        }

        public CitaDTO.Builder IdIps(Integer idIps) {
            this.idIps = idIps;
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
