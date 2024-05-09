package com.uis.MediConnect.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @Column(name = "idgenero")
    private Integer idGenero;
    @Column(name = "descripciongenero")
    private String Genero;

    public Genero() {
    }

    public Genero(Integer idGenero, String genero) {
        this.idGenero = idGenero;
        Genero = genero;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", Genero='" + Genero + '\'' +
                '}';
    }
}
