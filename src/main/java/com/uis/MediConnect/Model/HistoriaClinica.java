package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "historiaclinica")
public class HistoriaClinica {

    @Id
    @Column(name = "idhc")
    private String idHistoriaClinica;
    @Column(name = "descripcionhc")
    private String descripcion;
    @Column(name = "urlhc")
    private String urlHistoriaClinica;
    @Column(name = "idpaciente")
    private String idPaciente;
    @Column(name = "idmedico")
    private String idMedico;
    @Column(name = "idordentratamiento")
    private String idOrdenTratamiento;
    @Column(name = "idformulamedica")
    private String idFormulaMedica;

    public HistoriaClinica() {
    }

    public HistoriaClinica(String idHistoriaClinica, String descripcion, String urlHistoriaClinica, String idPaciente, String idMedico, String idOrdenTratamiento, String idFormulaMedica) {
        this.idHistoriaClinica = idHistoriaClinica;
        this.descripcion = descripcion;
        this.urlHistoriaClinica = urlHistoriaClinica;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idOrdenTratamiento = idOrdenTratamiento;
        this.idFormulaMedica = idFormulaMedica;
    }

    public String getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(String idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlHistoriaClinica() {
        return urlHistoriaClinica;
    }

    public void setUrlHistoriaClinica(String urlHistoriaClinica) {
        this.urlHistoriaClinica = urlHistoriaClinica;
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

    public String getIdOrdenTratamiento() {
        return idOrdenTratamiento;
    }

    public void setIdOrdenTratamiento(String idOrdenTratamiento) {
        this.idOrdenTratamiento = idOrdenTratamiento;
    }

    public String getIdFormulaMedica() {
        return idFormulaMedica;
    }

    public void setIdFormulaMedica(String idFormulaMedica) {
        this.idFormulaMedica = idFormulaMedica;
    }

    @Override
    public String toString() {
        return "HistoriaClinica{" +
                "idHistoriaClinica='" + idHistoriaClinica + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlHistoriaClinica='" + urlHistoriaClinica + '\'' +
                ", idPaciente='" + idPaciente + '\'' +
                ", idMedico='" + idMedico + '\'' +
                ", idOrdenTratamiento='" + idOrdenTratamiento + '\'' +
                ", idFormulaMedica='" + idFormulaMedica + '\'' +
                '}';
    }
}
