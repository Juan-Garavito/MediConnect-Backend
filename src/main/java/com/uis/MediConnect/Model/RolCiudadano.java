package com.uis.MediConnect.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "rolciudadano")
public class RolCiudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrolciudadano")
    Integer id;
    @Column(name = "numerodocumento")
    String numeroDocumento;
    @Column(name = "idrol")
    Integer idRol;

    public RolCiudadano() {
    }

    public RolCiudadano( String numeroDocumento, Integer idRol) {
        this.numeroDocumento = numeroDocumento;
        this.idRol = idRol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "RolCiudadano{" +
                "id=" + id +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", idRol=" + idRol +
                '}';
    }
}
