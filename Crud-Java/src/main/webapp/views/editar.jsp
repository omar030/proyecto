<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<title>Editar Producto</title>
</head>
<body>
	<h1>Editar Producto</h1>
	
	<div class="container">
		<form action="Producto" method="POST">
			<input type="hidden" name="opcion" value="editar" />
			<input type="hidden" class="form-control" name="id" id="id" value="<c:out value="${producto.id}"></c:out>" />
		  	
		  	<div class="form-group">
			    <label for="nombre">Nombre</label>
			    <input type="text" class="form-control" name="nombre" id="nombre" value="<c:out value="${producto.nombre}"></c:out>" />
		  	</div>
		 	<div class="form-group">
			    <label for="cantidad">Cantidad</label>
			    <input type="number" class="form-control" name="cantidad" id="cantidad"  value="<c:out value="${producto.cantidad}"></c:out>" />
		  	</div>
		  	<div class="form-group">
			    <label for="precio">Precio</label>
			    <input type="number" class="form-control" name="precio" id="precio"  value="<c:out value="${producto.precio}"></c:out>" />
		  	</div>
		  <button type="submit" class="btn btn-primary">Editar</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>