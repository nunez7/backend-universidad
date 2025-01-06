package com.vass.universidad.models.dto;

public class CarreraDTO {

    private Integer codigo;
    private String nombre;
    private Integer cantidad_materias;
    private Integer cantidad_cuatrimestres;

    public CarreraDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadMaterias() {
        return cantidad_materias;
    }

    public void setCantidadMaterias(Integer cantidadMaterias) {
        this.cantidad_materias = cantidadMaterias;
    }

    public Integer getCantidadCuatrimestres() {
        return cantidad_cuatrimestres;
    }

    public void setCantidadCuatrimestres(Integer cantidadCuatrimestres) {
        this.cantidad_cuatrimestres = cantidadCuatrimestres;
    }
}
