package com.uis.MediConnect.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Medicamento.TABLE_NAME)
public class Medicamento {
    
    public static final String TABLE_NAME = "medicamento";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedicamento")
    private Long id;
    
    @Column(name = "nombremedicamento")
    private String nombreMedicamento;
    
    @Column(name = "concentracion")
    private String concentracion;
    
    @Column(name = "formafarmaceutica")
    private String formaFarmaceutica;
    
    
    public Medicamento(){
        
    }

    public Medicamento(Long id, String nombreMedicamento, String concentracion, String formaFarmaceutica) {
        this.id = id;
        this.nombreMedicamento = nombreMedicamento;
        this.concentracion = concentracion;
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "id=" + id + ", nombreMedicamento=" + nombreMedicamento + ", concentracion=" + concentracion + ", formaFarmaceutica=" + formaFarmaceutica + '}';
    }  
}
