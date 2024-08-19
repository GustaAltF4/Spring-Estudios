<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/style.css">
<title>Confirmacion de Registro</title>
</head>
<body>
<!-- con los jsp tags(osea el signo "$" + "{}" ) rescatamos el objeto.propiedad  -->
El Alumno de nombre: <strong>${elAlumno.nombre}</strong> y Apellido: <strong>${elAlumno.apellido}<!--  --></strong> 
Edad: <strong>${elAlumno.edad}</strong>
Email:<strong>${elAlumno.email}</strong>
Codigo Postal:<strong>${elAlumno.codigoPostal}</strong>Se a registrado con Exito.<br><br>
La asignatura Opcional escogida es: <strong>${elAlumno.optativa }</strong>
La provincia cede de los Estudios del Alumno es:<strong>${elAlumno.ciudadCede}</strong>
Los idiomas escogidos por el Alumno son: <strong>${elAlumno.idiomasAlumno } </strong>
</body>
</html>