package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordentratamiento")
public class OrdenTratamiento {

    @Id
    @Column(name = "idordentratamiento")
    private String idOrdenTratamineto;
    @Column(name = "urlordentratamiento")
    private String urlOrdenTratamiento;
    @Column(name = "idexamen")
    private Integer idExamen;
    @Column(name = "idpaciente")
    private String idPaciente;
    @Column(name = "idmedico")
    private String idMedico;

    public OrdenTratamiento() {
    }

    public OrdenTratamiento(String idOrdenTratamineto, String urlOrdenTratamiento, Integer idExamen, String idPaciente, String idMedico) {
        this.idOrdenTratamineto = idOrdenTratamineto;
        this.urlOrdenTratamiento = urlOrdenTratamiento;
        this.idExamen = idExamen;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
    }

    public String getIdOrdenTratamineto() {
        return idOrdenTratamineto;
    }

    public void setIdOrdenTratamineto(String idOrdenTratamineto) {
        this.idOrdenTratamineto = idOrdenTratamineto;
    }

    public String getUrlOrdenTratamiento() {
        return urlOrdenTratamiento;
    }

    public void setUrlOrdenTratamiento(String urlOrdenTratamiento) {
        this.urlOrdenTratamiento = urlOrdenTratamiento;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
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

    @Override
    public String toString() {
        return "OrdenTratamiento{" +
                "idOrdenTratamineto='" + idOrdenTratamineto + '\'' +
                ", urlOrdenTratamiento='" + urlOrdenTratamiento + '\'' +
                ", idExamen=" + idExamen +
                ", idPaciente='" + idPaciente + '\'' +
                ", idMedico='" + idMedico + '\'' +
                '}';
    }
}
