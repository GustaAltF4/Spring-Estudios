package es.practicas.aop.dao;

import org.springframework.stereotype.Component;

import es.practicas.aop.Cliente;

@Component
public class ClienteDAO {
	
	

	public void insertaCliente(Cliente elCliente, String tipo) {
		
		//aca iria la logica real para insertar un cliente
		
		System.out.println("Trabajo realizado OK. Cliente insertado con exito.");
	
	}

	


}
