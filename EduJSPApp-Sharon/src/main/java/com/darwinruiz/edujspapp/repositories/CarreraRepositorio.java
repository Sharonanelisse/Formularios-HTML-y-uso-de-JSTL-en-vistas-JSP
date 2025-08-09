package com.darwinruiz.edujspapp.repositories;

import com.darwinruiz.edujspapp.models.Carrera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarreraRepositorio {
    private static final List<Carrera> carreras = new ArrayList<>();
    private static int secuenciaId = 1;

    // Método explícito para inicializar datos
    public CarreraRepositorio() {
        if (carreras.isEmpty()) {
            inicializarDatos();
        }
    }

    private void inicializarDatos() {
        carreras.add(new Carrera(secuenciaId++, "Ingeniería en sistemas", "250001", "Ingeniería", "Licenciatura", Arrays.asList("Presencial", "Virtual"), true, "No hay descripción" ));
    }

    public List<Carrera> listar() {
        return carreras;
    }

    public void agregar(Carrera carrera) {
        carrera.setId(secuenciaId++);
        carreras.add(carrera);
    }

    public Carrera buscarPorId(int id) {
        for (Carrera a : carreras) {
            if (a.getId() == id) return a;
        }
        return null;
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
        }
    }

    public void eliminar(int id) {
        carreras.removeIf(a -> a.getId() == id);
    }
}