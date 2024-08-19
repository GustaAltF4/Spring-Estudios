package es.practicas.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.practicas.aop.dao.ClienteDAO;


public class ClasePrincipal {

	public static void main(String[] args) {
		
		//leer la config de spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//obtener el bean del contenedor de spring
		
		ClienteDAO elCliente= contexto.getBean("clienteDAO",ClienteDAO.class);
		
		boolean miParam=false;
		
		try {
			elCliente.encuentraClientes(miParam);
	
		}catch (Exception e) {
			System.out.println("exepcion lanzada desde la clase princial");
			System.out.println(e.getMessage());
		}
		System.out.println("aqui continuaria la ejecucion del programa");
		
		//cerrar el contexto
		contexto.close();
		
	}

}
