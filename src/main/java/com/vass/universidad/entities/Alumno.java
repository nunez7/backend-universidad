package com.vass.universidad.entities;

public class Alumno extends Persona{

    private String matricula;

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellidos, Direccion direccion) {
        super(id, nombre, apellidos, direccion);
    }
}
