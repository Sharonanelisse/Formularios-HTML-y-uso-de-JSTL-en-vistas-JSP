package com.darwinruiz.edujspapp.services;

import com.darwinruiz.edujspapp.models.Carrera;
import com.darwinruiz.edujspapp.repositories.CarreraRepositorio;

import java.util.List;

public class CarreraService {
    private final CarreraRepositorio carreras = new CarreraRepositorio();

    public List<Carrera> obtenerTodos(){
        return carreras.listar();
    }

    private static int secuenciaId = 1;

    public void registrar(Carrera carrera) {
        carrera.setId(secuenciaId++);
        carreras.agregar(carrera);
    }

    public Carrera buscarPorId(int id) {
        return carreras.buscarPorId(id);
    }

    public void actualizar(Carrera carrera) {
        Carrera existente = buscarPorId(carrera.getId());
        if (existente != null) {
            existente.setNombre(carrera.getNombre());
            existente.setCodigo(carrera.getCodigo());
            existente.setFacultad(carrera.getFacultad());
            existente.setNivel(carrera.getNivel());
            existente.setModalidad(carrera.getModalidad());
            existente.setEstadoActiva(carrera.isEstadoActiva());
            existente.setDescripcion(carrera.getDescripcion());
            carreras.actualizar(existente);
        }
    }

    public void eliminar(int id) {
        carreras.eliminar(id);
    }
}
