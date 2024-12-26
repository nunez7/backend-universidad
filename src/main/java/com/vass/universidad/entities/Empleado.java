package com.vass.universidad.entities;

import com.vass.universidad.enums.TipoEmpleado;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona{

    private BigDecimal sueldo;

    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmpleado;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "edificio_id", foreignKey = @ForeignKey(name = "FK_EDIFICIO_ID"))
    private Edificio edificio;

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

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\t Empleado [sueldo=" + sueldo + ", tipoEmpleado=" + tipoEmpleado + ", edificio=" + edificio + "]";
    }

    
}
