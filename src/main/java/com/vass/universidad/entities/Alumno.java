package com.vass.universidad.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona{

    private String matricula;

    @ManyToOne(
        optional = true,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellidos, Direccion direccion) {
        super(id, nombre, apellidos, direccion);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\t Alumno [matricula=" + matricula + ", carrera=" + carrera + "]";
    }

    
}
