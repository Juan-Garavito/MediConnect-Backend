package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formulamedica")
public class FormulaMedica {

    @Id
    @Column(name = "idformulamedica")
    private String idFormulaMedica;
    @Column(name = "urlformulamedica")
    private String urlFormulaMedica;
    @Column(name = "idpaciente")
    private String idPaciente;
    @Column(name = "idmedico")
    private String idMedico;

    public FormulaMedica() {
    }

    public FormulaMedica(String idFormulaMedica, String urlFormulaMedica, String idPaciente, String idMedico) {
        this.idFormulaMedica = idFormulaMedica;
        this.urlFormulaMedica = urlFormulaMedica;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
    }

    public String getIdFormulaMedica() {
        return idFormulaMedica;
    }

    public void setIdFormulaMedica(String idFormulaMedica) {
        this.idFormulaMedica = idFormulaMedica;
    }

    public String getUrlFormulaMedica() {
        return urlFormulaMedica;
    }

    public void setUrlFormulaMedica(String getIdFormulaMedica) {
        this.urlFormulaMedica = getIdFormulaMedica;
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
        return "FormulaMedica{" +
                "idFormulaMedica='" + idFormulaMedica + '\'' +
                ", getIdFormulaMedica='" + urlFormulaMedica + '\'' +
                ", idPaciente='" + idPaciente + '\'' +
                ", idMedico='" + idMedico + '\'' +
                '}';
    }
}
