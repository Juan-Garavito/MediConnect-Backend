package com.uis.MediConnect.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @Column(name = "idespecialidad")
    private Integer id;
    @Column(name = "descripcionespecialidad")
    private String descripcion;

    @ManyToMany
    @JoinTable(name = "especialidadciudadanomedico",
            joinColumns =  @JoinColumn(name = "idespecialidad"),
            inverseJoinColumns = @JoinColumn(name = "numerodocumento")
    )
    private List<Ciudadano> ciudadanos;

    public Especialidad() {
    }

    public Especialidad(Integer id, String descripcion) {
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

    public List<Ciudadano> getCiudadanos() {
        return ciudadanos;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", ciudadanos=" + ciudadanos +
                '}';
    }
}
