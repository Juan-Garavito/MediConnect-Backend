package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposangre")
public class TipoSangre {

    @Id
    @Column(name = "idtiposangre")
    private Integer idSangre;
    @Column(name = "descripciontiposangre")
    private String tipoSangre;

    public TipoSangre() {
    }

    public TipoSangre(Integer idSangre, String tipoSangre) {
        this.idSangre = idSangre;
        this.tipoSangre = tipoSangre;
    }

    public Integer getIdSangre() {
        return idSangre;
    }

    public void setIdSangre(Integer idSangre) {
        this.idSangre = idSangre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    @Override
    public String toString() {
        return "TipoSangre{" +
                "idSangre=" + idSangre +
                ", tipoSangre='" + tipoSangre + '\'' +
                '}';
    }
}
