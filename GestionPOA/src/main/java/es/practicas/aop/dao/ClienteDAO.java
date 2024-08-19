package es.practicas.aop.dao;

import org.springframework.stereotype.Component;

import es.practicas.aop.Cliente;

@Component
public class ClienteDAO {
	
	

	public void insertaCliente(Cliente elCliente, String tipo) {
		
		//aca iria la logica real para insertar un cliente
		
		System.out.println("Trabajo realizado OK. Cliente insertado con exito.");
	
	}
	
	private String valoracionClienteNormal;
	private String codigoClienteNormal;
	
	
	
	public String getValoracionClienteNormal() {
		System.out.println("obteniendo valoracion del cliente");
		return valoracionClienteNormal;
	}



	public void setValoracionClienteNormal(String valoracionClienteNormal) {
		System.out.println("estableciendo valoracion del cliente");
		this.valoracionClienteNormal = valoracionClienteNormal;
	}



	public String getCodigoClienteNormal() {
		System.out.println("obteniendo codigo del cliente");
		return codigoClienteNormal;
	}



	public void setCodigoClienteNormal(String codigoClienteNormal) {
		System.out.println("estableciendo codigo del cliente");
		this.codigoClienteNormal = codigoClienteNormal;
	}



}
