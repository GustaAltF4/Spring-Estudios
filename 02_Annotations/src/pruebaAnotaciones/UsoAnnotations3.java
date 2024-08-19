package pruebaAnotaciones;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UsoAnnotations3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// cargar el xml de configuracion
		
		//ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext ("ApplicationContext.xml");
		
		//leer la class de de configuracion
		
		AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext(EmpleadosConfig.class);
		//entre parentesis la clase q tenemos con la annotation de configuracion SIN comillas
		
		//pedir un bean al contenedor
		
		DirectorFinanciero Ramon= contexto.getBean("directorFinancieroBean",DirectorFinanciero.class); 
		
		System.out.println(Ramon.getInforme());
		System.out.println(Ramon.getTareas());
		System.out.println("Email:"+Ramon.getEmail());
		System.out.println("Nombre de la empresa: "+Ramon.getNombreEmpre());
		
		contexto.close();
		
		
		
		;
				

	}

}
