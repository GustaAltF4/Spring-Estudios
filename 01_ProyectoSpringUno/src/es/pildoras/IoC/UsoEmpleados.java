package es.pildoras.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {
		
		
		// creacion de objetos de tipo empleado
		
		//Empleados empleado1= new DirectorEmpleado();
		
		// uso de los objetos creados
		
		//System.out.println(empleado1.getTareas());
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext ("applicationContext.xml");
		
		/*Empleados Juan=  contexto.getBean("miEmpleado", Empleados.class);
		
		System.out.println(Juan.getTareas());
		System.out.println(Juan.getInforme());*/
		
		/*SecretarioEmpleado Maria=  contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
	
		
		System.out.println(Maria.getTareas());
		System.out.println(Maria.getInforme());
		System.out.println("Email:" +Maria.getEmail());
		System.out.println("Empresa:" +Maria.getNombreEmpresa());*/
		
		DirectorEmpleado Maria=  contexto.getBean("miEmpleado", DirectorEmpleado.class);
	
		
		System.out.println(Maria.getTareas());
		System.out.println(Maria.getInforme());
		System.out.println("Email:" +Maria.getEmail());
		System.out.println("Empresa:" +Maria.getNombreEmpresa());

		
		
		
		contexto.close();

	}

}
