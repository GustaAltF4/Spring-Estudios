package es.practicas.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect//indica q es un aspecto
@Component
public class LoginConAspecto {  
	
	
//	//asi si espcificamos la ruta solo se aplica a uno de la clases
//	@Before("execution(public void es.practicas.aop.dao.ClienteVipDAO.insertaCliente())")//anotacion q indica q se ejecute antes de la comprabacion
//	public void antesInsertarCliente(){
//		
//		//aca se supone q iria la logica para comprobar q el usuario esta loguado y q tiene los permisos 
//		
//		System.out.println("El usuario esta logueado");
//		
//		System.out.println("el perfil con privilegios para insertar clientes es correcto");
//		
//	}
	
				//y en este caso aplica el aspecto a todo metodo q empiece igual q antes del *
		//@Before("execution(public * insertaCliente*(..))")//anotacion q indica q se ejecute antes de la comprabacion
		@Before("paqueteExeptoGETSET()")
		public void antesInsertarCliente(){
			
			//aca se supone q iria la logica para comprobar q el usuario esta loguado y q tiene los permisos 
			
			System.out.println("El usuario esta logueado");
			
			System.out.println("el perfil con privilegios para insertar clientes es correcto");
					}

		//@Before("paraClientes() ")
		public void requisitosCliente() {
			//aca iria toda la logica de los requisitos q quisieramos comprobar
			System.out.println("el cliente cumple todos los requisitos para ser agregado a la BBDD");
			
		}
		//@Before("paraClientes() ")
		public void requisitosTabla() {
			
			System.out.println("Hay menos de 3000 registro en la tabla .Puedes insertar el nuevo cliente");
		}
		
		
		//@Pointcut("execution(public * insertaCliente*(..))")
		@Pointcut("execution(* es.practicas.aop.dao.*.*(..))")//asi le decimos q actue sobre el paquete incluyendo sus metodos sin importar nombre parametros ni nada
		public void paraClientes() {
			//metodo q no hace nada simplemente para asignarle un nombre al pointcut
		}
		
		
		@Pointcut("execution(* es.practicas.aop.dao.*.get*(..))")//asi solo actuaria sobre getters
		public void paraGetters() {};
		@Pointcut("execution(* es.practicas.aop.dao.*.set*(..))")//asi solo actuaria sobre setters
		public void paraSetters() {};
		//osea q antes deq se realicen los get o set si al metodo le agrego @Before("paraGetters()") antes del q se ejecute un get o set ejecutaria el metodo con la anotacion

		//comvinacion de pintcuts
		@Pointcut("paraClientes() && !(paraGetters() || paraSetters())")
		public void paqueteExeptoGETSET() {};
		
}
