package es.practicas.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)//ordena el orden de ejecucion de los aspectos pero tienen q estar en clases separadas
public class RequisitosCliente {
	//para usar el Pointcut hay q espeecifiar la ruta de donde este el mismo
	
	@Before("es.practicas.aop.aspectos.LoginConAspecto.paraClientes()")
	private void requisitosCliente() {
		//aca iria toda la logica de los requisitos q quisieramos comprobar
		System.out.println("el cliente cumple todos los requisitos para ser agregado a la BBDD");
		
	}

}
