<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes de BBDD</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
</head>
<body>
<h1>Lista de Clientes</h1>
<table>

	<tr><!-- Encabezados de la lista html -->
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Email</th>
		<th colspan="2">Acciones Modificacion</th>
	</tr>
	<!-- var="clienteTemp": Nombre de la variable que representará cada elemento de la colección durante cada iteración.
					items="${clientes}": La colección sobre la que se itera.  -->
	<c:forEach var="clienteTemp" items="${clientes }">
		
		<!-- link para actualizar -->	
		<c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">
		
			<c:param name="clienteId" value="${clienteTemp.id}"></c:param>
		
		</c:url>
		
		<!-- link para eliminar -->
		<c:url var="linkEliminar" value="/cliente/eliminar">
		
			<c:param name="clienteId" value="${clienteTemp.id}"></c:param>
		
		</c:url>
		
		<tr><!-- iteración donde se generan dinámicamente filas de datos basadas en los objetos en la colección clientes -->
			<td>${clienteTemp.nombre}</td>
			<td>${clienteTemp.apellido}</td>
			<td>${clienteTemp.email}</td>
			<!-- botones -->
			<td><a href="${linkActualizar}"><input type="button" value="Modificar"></a></td>
			<td><a href="${linkEliminar}"><input type="button" value="Eliminar" 
			onclick="if(!(confirm('Estas por eliminar un registro. ¿Estas Seguro?'))) return false"></a></td>
		
		</tr>
	
	</c:forEach>

</table>

<br>

<input type="button" value="Agregar Cliente" onclick="window.location.href='muestraFormularioAgregar'; return false;"/>
<!-- 1-boton q al pulsar sobre el redireciona a la url muestraFormularioAgregar(se mapea en la clase Controlado)  -->
</body>
</html>