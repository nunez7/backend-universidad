package com.vass.universidad.models.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {

    private String calle;

    private String numero;

    private String codigoPostal;

    private String localidad;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String codigoPostal, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
