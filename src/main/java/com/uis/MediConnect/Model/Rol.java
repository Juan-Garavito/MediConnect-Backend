package com.uis.MediConnect.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rol")
public class Rol{

    @Id
    @Column(name = "idrol")
    private Integer idRol;
    @Column(name = "descripcionrol")
    private String nameRol;

    @ManyToMany
    @JoinTable(
            name = "rolciudadano",
            joinColumns = @JoinColumn(name = "idrol"),
            inverseJoinColumns = @JoinColumn(name = "numerodocumento"))
    private List<Ciudadano> ciudadanos;



    public List<Ciudadano> getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(List<Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    public Rol() {
    }

    public Rol(String nameRol, Integer idRol) {
        this.nameRol = nameRol;
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", nameRol='" + nameRol + '\'' +
                ", ciudadanos=" + ciudadanos +
                '}';
    }
}
