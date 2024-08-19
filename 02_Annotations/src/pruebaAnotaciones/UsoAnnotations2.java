package pruebaAnotaciones;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UsoAnnotations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// cargar el xml de configuracion
		
		//ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext ("ApplicationContext.xml");
		
		//leer la class de de configuracion
		
		AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext(EmpleadosConfig.class);
		//entre parentesis la clase q tenemos con la annotation de configuracion SIN comillas
		
		//pedir un bean al contenedor
		
		Empleados Antonio= contexto.getBean("ComercianteExperimentado", Empleados.class);
		Empleados Lucia= contexto.getBean("ComercianteExperimentado", Empleados.class);
		
		Empleados Ramon= contexto.getBean("directorFinancieroBean",Empleados.class);//este empleado 
		
		
		
		// apuntan al mismo objeto en memoria?
		//como antes por defecto Spring trabaja con Singleton
		// para trabajar con Prototype se agrega en la clase @Scope("prototype")
		
		if (Antonio==Lucia) {
			System.out.println("Apuntan al mismo lugar en memoria");
			System.out.println(Antonio+"\n"+Lucia);
		}else {
			System.out.println("NO Apuntan al mismo lugar en memoria");
			System.out.println(Antonio+"\n"+Lucia);
		}
		
		System.out.println(Ramon.getTareas());
		System.out.println(Ramon.getInforme());
		
		contexto.close();
				

	}

}
