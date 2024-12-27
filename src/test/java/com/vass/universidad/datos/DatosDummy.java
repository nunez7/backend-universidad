package com.vass.universidad.datos;

import com.vass.universidad.entities.*;

import java.math.BigDecimal;

import static com.vass.universidad.enums.TipoEmpleado.ADMINISTRATIVO;
import static com.vass.universidad.enums.TipoEmpleado.MANTENIMIENTO;

public class DatosDummy {
    public static Carrera carrera01(boolean conId){
        Carrera carrera = (conId) ? new Carrera(1, "Ingenieria en Sistemas", 50, 6) :
                new Carrera(null, "Ingenieria en Sistemas", 50, 6);
        return carrera;
    }

    public static Carrera carrera02(){
        return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
    }

    public static Carrera carrera03(boolean conId){
        Carrera carrera = (conId) ? new Carrera(3, "Ingenieria Industrial", 60, 5) :
                new Carrera(null, "Ingenieria Industrial", 60, 5);
        return carrera;
    }

    public static Persona empleado01() {
        return new Empleado(null, "Lautaro", "Lopez", new Direccion(), new BigDecimal("46750.70"), ADMINISTRATIVO);
    }

    public static Persona empleado02() {
        return new Empleado(null, "Lenadro", "Lopez", new Direccion(), new BigDecimal("46750.70"), MANTENIMIENTO);
    }

    public static Persona profesor01(){
        return new Profesor(null, "Martin", "Lugone", new Direccion(), new BigDecimal("60000.00"));
    }

    public static Persona alumno01(){
        return new Alumno(null, "Jhon", "Benitez", new Direccion(), "225222");
    }

    public static Persona alumno02(){
        return new Alumno(null, "Andres", "Benitez",  new Direccion(), "2202211");
    }

    public static Persona alumno03(){
        return new Alumno(null, "Joaquin", "Leon", new Direccion(), "45233012");
    }
}
