package com.uis.MediConnect.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {

    @Id
    private String numerodocumento;
    private String nombres;
    private String apellidos;
    private Date fechanacimiento;
    private Integer idgenero;
    private Integer idtiposangre;
    private String direccion;
    private String numerocelular;
    @Email(message = "Este correo no es valido")
    private String correo;
    @NotBlank(message = "Necesitas ingresar una contraseña")
    private String password;
    @ManyToMany(mappedBy = "ciudadanos")
    private List<Rol> rol;


    public Ciudadano() {

    }

    public Ciudadano(String numerodocumento, String nombres, String apellidos, Date fechanacimiento, Integer idgenero, Integer idtiposangre, String direccion, String numerocelular, String correo, String password) {
        this.numerodocumento = numerodocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.idgenero = idgenero;
        this.idtiposangre = idtiposangre;
        this.direccion = direccion;
        this.numerocelular = numerocelular;
        this.correo = correo;
        this.password = password;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public Integer getIdtiposangre() {
        return idtiposangre;
    }

    public void setIdtiposangre(Integer idtiposangre) {
        this.idtiposangre = idtiposangre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "numerodocumento='" + numerodocumento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", idgenero=" + idgenero +
                ", idtiposangre=" + idtiposangre +
                ", direccion='" + direccion + '\'' +
                ", numerocelular='" + numerocelular + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
