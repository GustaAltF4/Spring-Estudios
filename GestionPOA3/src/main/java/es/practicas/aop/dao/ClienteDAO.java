package es.practicas.aop.dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import es.practicas.aop.Cliente;

@Component
public class ClienteDAO {
	
	

	public void insertaCliente(Cliente elCliente, String tipo) {
		
		//aca iria la logica real para insertar un cliente
		
		System.out.println("Trabajo realizado OK. Cliente insertado con exito.");
	
	}
	
	public List<Cliente> encuentraClientes(boolean miParam){
		
		if(miParam) throw new RuntimeException("ERROR! no se a podido conectar con la BBDD");	
		
		
		List<Cliente> listaClientes= new ArrayList<>();
		
		//simular clientes devueltos por la BBDD
		
		Cliente cl1= new Cliente("Maria","Normal");
		Cliente cl2= new Cliente("Ana","Normal");
		Cliente cl3= new Cliente("Sandra","VIP");
		Cliente cl4= new Cliente("Pablo","Normal");
		
		//agregar Clientes a lista
		
		listaClientes.add(cl1);
		listaClientes.add(cl2);
		listaClientes.add(cl3);
		listaClientes.add(cl4);
		
		System.out.println("Ejecucion Finalizada del metodo encuentraClientes");
		
		return listaClientes;
		
	}

	


}
