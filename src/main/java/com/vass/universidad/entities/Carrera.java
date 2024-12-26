package com.vass.universidad.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 150)
    private String nombre;

    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;

    
    @Column(name = "cantidad_cuatrimestres")
    private Integer cantidadCuatrimestres;

    
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Integer cantidadMaterias, Integer cantidadCuatrimestres) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadCuatrimestres = cantidadCuatrimestres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(Integer cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public Integer getCantidadCuatrimestres() {
        return cantidadCuatrimestres;
    }

    public void setCantidadCuatrimestres(Integer cantidadCuatrimestres) {
        this.cantidadCuatrimestres = cantidadCuatrimestres;
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
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", cantidadCuatrimestres=" + cantidadCuatrimestres +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return Objects.equals(id, carrera.id) && Objects.equals(nombre, carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
