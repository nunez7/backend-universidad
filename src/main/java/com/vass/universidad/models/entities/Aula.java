package com.vass.universidad.models.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String abreviatura;

    private String descripcion;

    @Column(name = "cantidad_pupitres")
    private Integer cantidadPupitres;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "edificio_id", foreignKey = @ForeignKey(name = "FK_EDIFICIO_ID"))
    private Edificio edificio;

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

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @PrePersist
    public void antesPersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    public void antesUpdate(){
        this.fechaModificacion = LocalDateTime.now();
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
