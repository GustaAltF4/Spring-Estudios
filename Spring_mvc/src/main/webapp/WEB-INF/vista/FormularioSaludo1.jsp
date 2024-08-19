<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/style.css">
</head>
<body>

<h2>Formulario Ejemplo</h2>
	<form action="procesarFormulario3" method= "get"><!-- caja q tiene definida la accion de ir al link /procesarFormulario -->
		<input type="text" name="nombreAlumno">
		<input type="submit">
	</form>
	
<img alt="foto" src="${pageContext.request.contextPath}/recursos/img/22.png">
<img alt="Imagen 1" src="${pageContext.request.contextPath}/recursos/img/23.jpg" >

	

</body>
</html>