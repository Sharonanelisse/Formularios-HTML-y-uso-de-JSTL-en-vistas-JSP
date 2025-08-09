package com.darwinruiz.edujspapp.repositories;

import com.darwinruiz.edujspapp.models.Profesor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProfesorRepositorio {
    private static final List<Profesor> profesores = new ArrayList<>();
    private static int secuenciaId = 1;

    // Método explícito para inicializar datos
    public ProfesorRepositorio() {
        if (profesores.isEmpty()) {
            inicializarDatos();
        }
    }

    private void inicializarDatos() {
        profesores.add(new Profesor(
                secuenciaId++,
                "Eddy Roberto",
                "eddy@uspg.com",
                "Masculino",
                true,
                "Historia",
                Arrays.asList("Historia, Matemática"),
                "",
                "27/01/2024"
        ));
    }

    public List<Profesor> listar() {
        return profesores;
    }

    public void agregar(Profesor profesor) {
        profesor.setId(secuenciaId++);
        profesores.add(profesor);
    }

    public Profesor buscarPorId(int id) {
        for (Profesor a : profesores) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public void actualizar(Profesor profesor) {
        Profesor existente = buscarPorId(profesor.getId());
        if (existente != null) {
            existente.setNombre(profesor.getNombre());
            existente.setEspecialidad(profesor.getEspecialidad());
        }
    }

    public void eliminar(int id) {
        profesores.removeIf(a -> a.getId() == id);
    }

}
