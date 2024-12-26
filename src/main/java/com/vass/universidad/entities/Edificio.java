package com.vass.universidad.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import org.apache.logging.log4j.util.Lazy;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "edificios")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String descripcion;

    @Embedded
    @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal"))
    private Direccion direccion;

    @Column(name = "fecha_alta") 
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @OneToMany(mappedBy = "edificio", fetch = FetchType.LAZY)
    private Set<Aula> aulas;

    public Edificio() {
    }

    public Edificio(Integer id, String descripcion, Direccion direccion) {
        this.id = id;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    public Set<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", direccion=" + direccion +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edificio edificio = (Edificio) o;
        return Objects.equals(id, edificio.id) && Objects.equals(descripcion, edificio.descripcion);
    }


    @PrePersist
    public void antesPersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    public void antesUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }
}
