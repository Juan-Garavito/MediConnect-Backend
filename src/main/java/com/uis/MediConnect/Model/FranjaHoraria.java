package com.uis.MediConnect.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity()
@Table(name = "franjahoraria")
public class FranjaHoraria {

    @Id
    @Column(name = "idfranjahoraria")
    private Integer id;
    @Column(name = "descripcionfh")
    private String descripcion;

    @OneToMany(mappedBy = "idFranjaHoraria")
    private List<DisponibilidadMedico> disponibilidadMedico;

    public FranjaHoraria() {
    }

    public FranjaHoraria(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "FranjaHoraria{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
