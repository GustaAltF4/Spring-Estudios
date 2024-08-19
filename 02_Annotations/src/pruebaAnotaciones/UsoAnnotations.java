package pruebaAnotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// cargar el xml de configuracion
			
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext ("ApplicationContext.xml");
		
		
		//pedir un bean al contenedor
		
		Empleados Antonio= contexto.getBean("ComercianteExperimentado", Empleados.class);
		
		//usar el bean 
		
		System.out.println(Antonio.getTareas());
		System.out.println(Antonio.getInforme());
		
		//cerrar el contexto
		
		contexto.close();
	}

}
