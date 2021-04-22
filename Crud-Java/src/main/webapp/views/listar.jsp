<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Listar Producto</title>
</head>
<body>
	<h1>Listar Producto</h1>
	
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Nombre</th>
	      <th scope="col">Cantidad</th>
	      <th scope="col">Precio</th>
	      <th scope="col">Fecha Creacion</th>
	      <th scope="col">Fecha Actualizacion</th>
	      <th scope="col">Acciones</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:if test="${listaProducto != null}">
		  <c:forEach var="producto" items="${listaProducto}"> 
		    <tr>    	
		      <th><c:out value="${producto.nombre}"></c:out></th>
		      <td><c:out value="${producto.cantidad}"></c:out></td>
		      <td><c:out value="${producto.precio}"></c:out></td>
		      <td><c:out value="${producto.fecha_crear}"></c:out></td>
		      
		      <td><c:out value="${producto.fecha_actualizar}"></c:out></td>
		      
		      <td>
		      <a class="btn btn-outline-primary" href="Producto?opcion=showeditar&id=<c:out value="${producto.id}" />">Editar</a>
		      <a class="btn btn-outline-danger" href="Producto?opcion=eliminar&id=<c:out value="${producto.id}" />">Eliminar</a>
		      </td>
		    </tr>
		   </c:forEach>
		</c:if>
	    <c:if test="${listaProducto == null}">
	    	<tr>
	     	<td colspan="6" style="text-align: center;">No existen datos...</td>
	     	</tr>
	     </c:if>
	  </tbody>
	</table>
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>