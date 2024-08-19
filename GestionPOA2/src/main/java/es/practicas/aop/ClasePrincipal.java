package es.practicas.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.practicas.aop.dao.ClienteDAO;
import es.practicas.aop.dao.ClienteVipDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		//leer la config de spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//obtener el bean del contenedor de spring
		
		ClienteDAO elCliente= contexto.getBean("clienteDAO",ClienteDAO.class);
		ClienteVipDAO elClienteVIP= contexto.getBean("clienteVipDAO",ClienteVipDAO.class);
		
		//llamar al metodo
		Cliente cliente1= new Cliente();
		
		cliente1.setNombre("Gustavo Acosta");
		cliente1.setTipo("Normal");
		
		elCliente.insertaCliente(cliente1,cliente1.getTipo()); //este es el nombre del metodo q debe coincidir con la anotacion @Before
		System.out.println("");
		elClienteVIP.insertaClienteVIP();
		
		//cerrar el contexto
		contexto.close();
		
	}

}
