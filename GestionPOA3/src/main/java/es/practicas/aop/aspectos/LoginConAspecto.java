package es.practicas.aop.aspectos;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.practicas.aop.Cliente;

/*
 *  @After: Se ejecuta después de la ejecución del método objetivo, independientemente de si termina con éxito o lanza una excepción.
 *	@AfterReturning: Se ejecuta solo si el método objetivo termina con éxito.
 *	@AfterThrowing: Se ejecuta solo si el método objetivo lanza una excepción.
 */



@Aspect//indica q es un aspecto
@Component
@Order(2)//ordena el orden de ejecucion de los aspectos pero tienen q estar en clases separadas
public class LoginConAspecto { 
	
		@Around("execution(* es.practicas.aop.servicios.*.getServicio(..))")
		public Object ejecutarServicio(ProceedingJoinPoint elPoint) throws Throwable{
			
			System.out.println("------COMIENZO DE ACCIONES ANTES DE LLAMADA-------");
			long comienzo= System.currentTimeMillis();//ejemplo de como capurar la duracion de lo q tarda el metodo
			
			Object resultado=elPoint.proceed(); //elPiont apunta al metodo destino osea ejecuta el metodo 
			
			System.out.println("------TAREAS DESPUES DE LLAMADAS------");
			long fin=System.currentTimeMillis();
			long duracion= fin-comienzo;
			System.out.println("El metodo tardo: "+ duracion/1000 +"seg");
			
			return resultado;
		}
	
	
		@After("execution(* es.practicas.aop.dao.ClienteDAO.encuentraClientes(..))")
		public void ejecutandoTareasConYsinExcepcion(JoinPoint elPoint) {
			
			System.out.println("ejecutando tareas SIEMPRE!!!");
			
		}
	
	
		@AfterThrowing(pointcut="execution(* es.practicas.aop.dao.ClienteDAO.encuentraClientes(..))",throwing="LaExcepcion")
		public void procesadoDatosExceptionEncuentraClientes(Throwable LaExcepcion) {
			
			System.out.println("aqui se estarian ejecutando de forma automatica las tareas despues de la excepcion");
			
		}
	
	
		@AfterReturning(pointcut="execution(* es.practicas.aop.dao.ClienteDAO.encuentraClientes(..))",returning="listaDeClientes")
		public void tareaTrasEcontrarCliente(List<Cliente> listaDeClientes) {
			
			for (Cliente cl : listaDeClientes) {
				
				
				
				if(cl.getTipo()=="VIP") {
					procesadoDatosAfterReturning(listaDeClientes);
					
					System.out.println("Extisten clientes VIP en el listado. Nombre: "+cl.getNombre());
				}
			}
			
		}
	
	
		private void procesadoDatosAfterReturning(List<Cliente> listaDeClientes) {
			
			for (Cliente cl : listaDeClientes) {
				
				
				String datosProcesados="V.I.P "+ cl.getNombre().toUpperCase();
				
				cl.setNombre(datosProcesados);
			}
			
		}


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
