package es.pildoras.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDemoSingletonPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//carga de xml de configuracion
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext ("applicationContext2.xml");
		
		//peticion de beans al contenedor Spring
		
		SecretarioEmpleado Maria=  contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado Pedro=  contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado Pedro2=  contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado Pedro3=  contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);


		System.out.println(Maria);
		System.out.println(Pedro);
		System.out.println(Pedro2);
		System.out.println(Pedro3);
		
//		if (Maria==Pedro) System.out.println("Apuntan al mismo Objeto");
//		else System.out.println("No Apuntan al mismo Objeto");
		
		contexto.close();
	}

}
