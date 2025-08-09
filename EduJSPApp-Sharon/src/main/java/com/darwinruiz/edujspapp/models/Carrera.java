package com.darwinruiz.edujspapp.models;

import java.util.List;

public class Carrera {
    private int id;
    private String nombre;
    private String codigo;
    private String facultad;
    private String nivel;
    private List<String> modalidad;
    private boolean estadoActiva;
    private String descripcion;

    public Carrera() {}

    public Carrera(int id, String nombre, String codigo, String facultad, String nivel, List<String> modalidad, boolean estadoActiva, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.facultad = facultad;
        this.nivel = nivel;
        this.modalidad = modalidad;
        this.estadoActiva = estadoActiva;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFacultad() {
        return facultad;
    }

    public String getNivel() {
        return nivel;
    }

    public List<String> getModalidad() {
        return modalidad;
    }

    public boolean isEstadoActiva() {
        return estadoActiva;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setModalidad(List<String> modalidad) {
        this.modalidad = modalidad;
    }

    public void setEstadoActiva(boolean estadoActiva) {
        this.estadoActiva = estadoActiva;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
