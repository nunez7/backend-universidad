package com.vass.universidad.models.entities;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona{

    private BigDecimal sueldo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "profesor_carrera", 
        joinColumns = @JoinColumn(name = "profesor_id"),
        inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private Set<Carrera> carreras;

    public Profesor() {
    }

    public Profesor(Integer id, String nombre, String apellidos, Direccion direccion,BigDecimal sueldo) {
        super(id, nombre, apellidos, direccion);
        this.sueldo = sueldo;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Set<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return 
        super.toString() +
        "\t Profesor [sueldo=" + sueldo + "]";
    }

    
}
