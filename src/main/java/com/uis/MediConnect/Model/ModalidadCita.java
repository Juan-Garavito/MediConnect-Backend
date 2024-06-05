package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modalidadcita")
public class ModalidadCita {

    @Id
    @Column(name = "idmodalidadcita")
    private Integer id;
    @Column(name = "descripcionmodalidad")
    private String descripcion;

    public ModalidadCita() {
    }

    public ModalidadCita(Integer id, String descripcion) {
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
        return "ModalidadCita{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
