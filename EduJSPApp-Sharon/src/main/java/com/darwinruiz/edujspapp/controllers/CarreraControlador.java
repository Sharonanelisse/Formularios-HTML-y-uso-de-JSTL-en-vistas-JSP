package com.darwinruiz.edujspapp.controllers;


import com.darwinruiz.edujspapp.models.Carrera;
import com.darwinruiz.edujspapp.services.CarreraService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/carreras")
public class CarreraControlador extends HttpServlet {
    private final CarreraService service = new CarreraService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) accion = "formulario";

        switch (accion) {
            case "listar" -> {
                request.setAttribute("carreras", service.obtenerTodos());
                request.setAttribute("vista", "/views/carreras/lista_carreras.jsp");
            }
            case "editar" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                Carrera carrera = service.buscarPorId(id);
                request.setAttribute("carrera", carrera);
                request.setAttribute("vista", "/views/carreras/formulario_carreras.jsp");
            }
            case "eliminar" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                service.eliminar(id);
                response.sendRedirect("carreras?accion=listar");
                return;
            }
            default -> request.setAttribute("vista", "/views/carreras/formulario_carreras.jsp");
        }

        request.getRequestDispatcher("plantilla.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idTexto = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String codigo = request.getParameter("codigo");
        String facultad = request.getParameter("facultad");
        String nivel = request.getParameter("nivel");
        String[] modalidad = request.getParameterValues("modalidad");
        boolean estadoActiva = request.getParameter("estadoActiva") != null;
        String descripcion = request.getParameter("descripcion");

        Carrera carrera = new Carrera(
                idTexto != null && !idTexto.isBlank() ? Integer.parseInt(idTexto) : 0,
                nombre,
                codigo,
                facultad,
                nivel,
                modalidad != null ? List.of(modalidad) : List.of(),
                estadoActiva,
                descripcion
        );

        if (idTexto == null || idTexto.isBlank()) {
            service.registrar(carrera);
        } else {
            service.actualizar(carrera);
        }

        response.sendRedirect("carreras?accion=listar");
    }
}
