package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.Date;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @Column(name = "idcita")
    private String idCita;
    @Column(name = "fechacita")
    private Date fechaCita;
    @Column(name = "idfranjahoraria")
    private Integer idFranjaHoraria;
    @Column(name = "idespecialidad")
    private Integer idEspecialidad;
    @Column(name = "idmodalidadcita")
    private Integer idModalidadCita;
    @Column(name = "idpaciente")
    private String idPaciente;
    @Column(name = "idmedico")
    private String idMedico;
    @Column(name = "idips")
    private Integer idIps;

    public Cita() {
    }

    public Cita(String idCita, Date fechaCita, Integer idFranjaHoraria, Integer idEspecialidad, Integer idModalidadCita, String idPaciente, String idMedico, Integer idIps) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.idFranjaHoraria = idFranjaHoraria;
        this.idEspecialidad = idEspecialidad;
        this.idModalidadCita = idModalidadCita;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idIps = idIps;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Integer getIdFranjaHoraria() {
        return idFranjaHoraria;
    }

    public void setIdFranjaHoraria(Integer idFranjaHoraria) {
        this.idFranjaHoraria = idFranjaHoraria;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdModalidadCita() {
        return idModalidadCita;
    }

    public void setIdModalidadCita(Integer idModalidadCita) {
        this.idModalidadCita = idModalidadCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdIps() {
        return idIps;
    }

    public void setIdIps(Integer idIps) {
        this.idIps = idIps;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita='" + idCita + '\'' +
                ", fechaCita=" + fechaCita +
                ", idFranjaHoraria=" + idFranjaHoraria +
                ", idEspecialidad=" + idEspecialidad +
                ", idModalidadCita=" + idModalidadCita +
                ", idPaciente='" + idPaciente + '\'' +
                ", idMedico='" + idMedico + '\'' +
                ", idIps=" + idIps +
                '}';
    }
}
