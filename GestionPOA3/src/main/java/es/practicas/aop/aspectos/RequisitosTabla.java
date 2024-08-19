package es.practicas.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)//ordena el orden de ejecucion de los aspectos pero tienen q estar en clases separadas
public class RequisitosTabla {

	

	@Before("es.practicas.aop.aspectos.LoginConAspecto.paraClientes()")
	private void requisitosTabla() {
		
		System.out.println("Hay menos de 3000 registro en la tabla .Puedes insertar el nuevo cliente");
	}
	
}
