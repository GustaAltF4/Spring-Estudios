package es.practicas.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import es.practicas.aop.servicios.MedicionServicios;


public class ClasePrincipal2 {

	public static void main(String[] args) {
		
		//leer la config de spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//obtener el bean del contenedor de spring
		
		MedicionServicios elServicio= contexto.getBean("medicionServicios",MedicionServicios.class);
		
		System.out.println("Llamando al metodo getServicio");
		
		String datos= elServicio.getServicio();
		
		System.out.println("Devolucion del metodo: "+ datos);
		
		//cerrar el contexto
		contexto.close();
		
	}

}
