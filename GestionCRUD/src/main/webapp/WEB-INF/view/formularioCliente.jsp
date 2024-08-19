<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
</head>
<body>
<!-- 3 creamos el formulario q va a insertar el cliente -->
	<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
		
		<form:hidden path="id"/>
		
		<table>
		
			<tr>
				<td>Nombre: </td>
				<td><form:input path="nombre"/></td>
			</tr>
			
			<tr>
				<td>Apellido: </td>
				<td><form:input path="apellido"/></td>
			</tr>
			
			<tr>
				<td>E-mail: </td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Cargar"></td>
	<!-- al pulsar ese boton vamos a la direccion action="insertarCliente" poniendole el atributo modelAttribute="cliente"
	sumado a los datos viajan en el ... el controlardor ahora va a mapear insertarCliente  -->
				
			</tr>
			
			
		
		
		</table>
	
	
	</form:form> 
 

</body>
</html>