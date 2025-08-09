<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Formulario de Carrera</h2>

<form method="post" action="" class="row g-3">
  <c:if test="${carrera != null}">
    <input type="hidden" name="id" value="${carrera.id}" />
  </c:if>

  <div class="col-md-6">
    <label>Nombre de la carrera:</label>
    <input type="text" name="nombre" class="form-control" required
           value="${carrera != null ? carrera.nombre : ''}" />
  </div>

  <div class="col-md-6">
    <label>Código de la carrera:</label>
    <input type="text" name="codigo" class="form-control" required
           value="${carrera != null ? carrera.codigo : ''}" />
  </div>


  <div class="col-md-6">
    <label>Facultad:</label>
    <select name="facultad" class="form-select">
      <c:forEach var="facultad" items="${['Ingeniería','Derecho','Humanidades','Medicina']}">
        <option value="${facultad}"
                <c:if test="${carrera.facultad == facultad}">selected</c:if>>${facultad}
        </option>
      </c:forEach>
    </select>
  </div>

  <div class="col-md-6">
    <label>Nivel academico:</label>
    <select name="nivel" class="form-select">
      <c:forEach var="nivel" items="${['Técnico','Licenciatura','Maestría']}">
        <option value="${nivel}"
                <c:if test="${carrera.nivel == nivel}">selected</c:if>>${nivel}
        </option>
      </c:forEach>
    </select>
  </div>

  <div class="col-md-6">
    <label>Modalidad:</label>
    <select name="modalidad" class="form-select" multiple size="4">
      <c:forEach var="modalidad" items="${['Presencial','Virtual','Semipresencial']}">
        <option value="${modalidad}"
                <c:if test="${carrera.modalidad != null && carrera.modalidad.contains(modalidad)}">selected</c:if>>
            ${modalidad}
        </option>
      </c:forEach>
    </select>
  </div>

  <div class="col-md-6">
    <label>Carrera activa:</label><br />
    <input type="checkbox" name="estadoActiva"
           <c:if test="${carrera.estadoActiva}">checked</c:if> /> Sí
  </div>
  <div class="col-12">
    <label>Descripción:</label>
    <textarea name="descripcion" class="form-control">${carrera != null ? carrera.descripcion : ''}</textarea>
  </div>

  <div class="col-12">
    <button type="submit" class="btn btn-success">Guardar</button>
    <a href="?accion=listar" class="btn btn-secondary">Cancelar</a>
  </div>
</form>
