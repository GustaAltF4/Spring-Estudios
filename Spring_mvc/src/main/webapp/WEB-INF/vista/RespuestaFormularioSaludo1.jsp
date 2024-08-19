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
<!-- respuesta al formulario con el metodo ${param.dato-a-obtener} q obtiene el valor del input name="nombreAlumno" -->
Hola ${param.nombreAlumno} . Bienvenido al curso de Spring bla bla bla...

<p><br>
<h2>Atencion!!!</h2>
${mensajeClaro}
<br>
<img alt="foto" src="${pageContext.request.contextPath}/recursos/img/22.png">
<!-- El uso de ${pageContext.request.contextPath} permite que tu aplicación maneje correctamente
 las rutas de recursos independientemente de cómo o dónde se despliegue osea q si se llega a cambiar
  la ruta (osea el link) la imagen seria flexible a esos cambios-->


</body>
</html>