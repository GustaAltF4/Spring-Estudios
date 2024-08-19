package es.practicas.aop.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.practicas.aop.Cliente;

@Aspect//indica q es un aspecto
@Component
@Order(2)//ordena el orden de ejecucion de los aspectos pero tienen q estar en clases separadas
public class LoginConAspecto { 
	
	
		//@Pointcut("execution(public * insertaCliente*(..))")
		@Pointcut("execution(* es.practicas.aop.dao.*.*(..))")
		public void paraClientes() {}
	
		
		
		@Before("paraClientes()")
		private void antesInsertarCliente(JoinPoint miJoin){//join point crea un punto de intercepcion
			
			//aca se supone q iria la logica para comprobar q el usuario esta loguado y q tiene los permisos 
			
			System.out.println("El usuario esta logueado");
			
			System.out.println("el perfil con privilegios para insertar clientes es correcto");
			
			Object[] argumentos= miJoin.getArgs();//este metodo getArgs de JoinPoint devuelve en un array todos los argumentos de la funcion q use el aspecto
		
			for (Object aux : argumentos) {//recorremos el array de tipo object en este caso tenia un objeto tipo Cliente y un String
				//System.out.println(aux);	
				
				if(aux instanceof Cliente ) {//solo recatamos el Cliente
					
					Cliente elCliente=(Cliente) aux;// lo guardamos en una variable tipo cliente
					
					System.out.println("Nombre del Cliente: "+elCliente.getNombre());//accedo a sus propiedades del cliente obtenido
					System.out.println("Tipo del Cliente: "+elCliente.getTipo());
				}
				
			}
		
		}

		
	
		
}
