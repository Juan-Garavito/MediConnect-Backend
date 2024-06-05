package com.uis.MediConnect.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "disponibilidadmedico")
public class DisponibilidadMedico {

    @Id
    @Column(name = "iddisponibilidadmedico")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Ciudadano idMedico;

    @ManyToOne
    @JoinColumn(name = "idfranjahoraria")
    private FranjaHoraria idFranjaHoraria;

    @Column(name = "estado")
    private boolean Estado;

    @Column(name = "fecha")
    private LocalDate Fecha;

    public DisponibilidadMedico() {
    }

    public DisponibilidadMedico(Integer id, Ciudadano idMedico, FranjaHoraria idFranjaHoraria, boolean estado, LocalDate fecha) {
        this.id = id;
        this.idMedico = idMedico;
        this.idFranjaHoraria = idFranjaHoraria;
        Estado = estado;
        Fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ciudadano getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Ciudadano idMedico) {
        this.idMedico = idMedico;
    }

    public FranjaHoraria getIdFranjaHoraria() {
        return idFranjaHoraria;
    }

    public void setIdFranjaHoraria(FranjaHoraria idFranjaHoraria) {
        this.idFranjaHoraria = idFranjaHoraria;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    @Override
    public String toString() {
        return "DisponibilidadMedico{" +
                "id=" + id +
                ", idMedico=" + idMedico +
                ", idFranjaHoraria=" + idFranjaHoraria +
                ", Estado=" + Estado +
                ", Fecha=" + Fecha +
                '}';
    }
}
