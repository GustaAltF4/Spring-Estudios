<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Directiva para usar las form mvc tags (https://www.javatpoint.com/spring-mvc-form-tag-library) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/style2.css">
<title>Formulario de Registro</title>
</head>
<body>
<!-- modelAttribute="nombre identificativo de objeto model"
en este caso modelo.addAttribute("alumno01", alumno1);  -->
<form:form action="procesarFormulario" modelAttribute="elAlumno">

Nombre: <form:input path="nombre"/><form:errors path="nombre" style="color:#FF77C4"/>
<br><br><br>
<!--  path="valor del setter y getter pero sin Set y con minuscula" 
en este caso public void setNombre()||al cargar datos->getter||al enviar datos->setter||-->
Apellido: <form:input path="apellido"/><br><br><br>

Edad: <form:input path="edad"/><form:errors path="edad" style="color:#FF77C4"/>
<br><br><br>
E-Mail: <form:input path="email"/><form:errors path="email" style="color:#FF77C4"/>
<br><br><br>
Codigo Postal: <form:input path="codigoPostal"/><form:errors path="codigoPostal" style="color:#FF77C4"/>
<br><br><br>


Asignaturas Optativas:<br/>

<form:select path="optativa" ><!--multiple="true"  -->
<!-- aca hay q tener cuidado puse "optativas" y eso daria error porq en el java esta como "optativa"-->
	
	<form:option value="Diseño" label="Diseño"/>
	<form:option value="Karate" label="Karate"/>
	<form:option value="Ingles" label="Plastica"/>
	<form:option value="Musica" label="Musica"/>

</form:select>
<br><br><br>
Ciudad de Cede:<br/>
	Mendoza<form:radiobutton path="ciudadCede" value="Mendoza"/>
	Buenos Aires<form:radiobutton path="ciudadCede" value="Buenos Aires"/>
	San Luis<form:radiobutton path="ciudadCede" value="San Luis"/>
<br><br><br>
Idiomas a aprender:
	Ingles<form:checkbox path="idiomasAlumno" value="Ingles"/>
	Frances<form:checkbox path="idiomasAlumno" value="Frances"/>
	Chino<form:checkbox path="idiomasAlumno" value="Chino"/>
	Italiano<form:checkbox path="idiomasAlumno" value="Italiano"/>

<br><br><br>

<input type="submit" value="Cargar Datos">
</form:form>

</body>
</html>