package com.vass.universidad.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Aula {

    private Integer id;

    private String abreviatura;

    private String descripcion;

    private Integer cantidadPupitres;

    private LocalDateTime fechaAlta;

    private LocalDateTime fechaModificacion;

    public Aula() {
    }

    public Aula(Integer id, String abreviatura, String descripcion, Integer cantidadPupitres) {
        this.id = id;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
        this.cantidadPupitres = cantidadPupitres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidadPupitres() {
        return cantidadPupitres;
    }

    public void setCantidadPupitres(Integer cantidadPupitres) {
        this.cantidadPupitres = cantidadPupitres;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", abreviatura='" + abreviatura + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadPupitres=" + cantidadPupitres +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return Objects.equals(id, aula.id) && Objects.equals(abreviatura, aula.abreviatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abreviatura);
    }
}
