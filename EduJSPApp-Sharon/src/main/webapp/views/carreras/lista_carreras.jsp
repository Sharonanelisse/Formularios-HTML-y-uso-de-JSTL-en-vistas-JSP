<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h2>Listado de Careras</h2>
<c:choose>
    <c:when test="${fn:length(carreras) > 0}">
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Código</th>
                <th>Facultad</th>
                <th>Nivel</th>
                <th>Modalidad</th>
                <th>Estado</th>
                <th>Descripcion</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${carreras}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nombre}</td>
                    <td>${p.codigo}</td>
                    <td>${p.facultad}</td>
                    <td>${p.nivel}</td>
                    <td>
                        <ul class="mb-0">
                            <c:forEach var="c" items="${p.modalidad}">
                                <li>${c}</li>
                            </c:forEach>
                        </ul>
                    </td>

                    </td>
                    <td>
                        <c:choose>
                        <c:when test="${p.estadoActiva}">Sí</c:when>
                        <c:otherwise>No</c:otherwise>
                        </c:choose>
                    <td>${p.descripcion}</td>
                    <td>
                        <a href="?accion=editar&id=${p.id}" class="btn btn-sm btn-primary">Editar</a>
                        <a href="?accion=eliminar&id=${p.id}" class="btn btn-sm btn-danger"
                           onclick="return confirm('¿Eliminar esta carrera?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <h4>No hay carreras registradas</h4>
    </c:otherwise>

</c:choose>
