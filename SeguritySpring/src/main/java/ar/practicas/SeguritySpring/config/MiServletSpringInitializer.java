package ar.practicas.SeguritySpring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//AbstractAnnotationConfigDispatcherServletInitializer es una clase proporcionada por Spring que facilita
//la configuración de aplicaciones web basadas en Spring MVC sin necesidad de un archivo web.xml. 
//Esta clase es parte de la configuración basada en Java de Spring.

public class MiServletSpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
		//Aquí defines las clases de configuración de la aplicación (si las hay). 
		//Estas clases configuran el contexto raíz de la aplicación, que puede incluir servicios, repositorios, etc.
		//Si no hay configuración de raíz, puedes devolver null
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {App.class};
		//Aquí defines las clases de configuración específicas para el DispatcherServlet.
		//Generalmente, esta clase contiene la configuración de Spring MVC, como los @Configuration
		//que configuran los controladores, vistas, etc.
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
		//Aquí defines los patrones de URL que deben ser manejados por el DispatcherServlet.
		//Usualmente, se mapea el servlet a todas las solicitudes ("/"), lo que significa que manejará todas las solicitudes entrantes.
	}

}
