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
		Cliente Cliente1= new Cliente();
		elCliente.insertaCliente(Cliente1,"Normal"); //este es el nombre del metodo q debe coincidir con la anotacion @Before
		System.out.println("");
		elClienteVIP.insertaClienteVIP();
		
		//cerrar el contexto

		elCliente.setCodigoClienteNormal("123123");
		elCliente.setValoracionClienteNormal("Positiva");
		//String codigoCl=elCliente.getCodigoClienteNormal();
		//String valoracionCl=elCliente.getValoracionClienteNormal();
		contexto.close();
		
	}

}
