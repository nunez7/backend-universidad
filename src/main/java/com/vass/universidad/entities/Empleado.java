package com.vass.universidad.entities;

import com.vass.universidad.enums.TipoEmpleado;

import java.math.BigDecimal;

public class Empleado extends Persona{

    private BigDecimal sueldo;

    private TipoEmpleado tipoEmpleado;

    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String apellidos, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellidos, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
