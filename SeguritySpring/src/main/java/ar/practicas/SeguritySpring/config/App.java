package ar.practicas.SeguritySpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="ar.practicas.SeguritySpring")
public class App {
    
	@Bean
	public ViewResolver viewResolver() {
		
		//InternalResourceViewResolver basicamente se encarga de econtrar las rutas a las vistas mas facilmente
		
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");// indicamos q antes del nombre de la vista va a estar esta ruta
		
		viewResolver.setSuffix(".jsp");//indica la extencion de las vistas
		
		return viewResolver;
		
	}
}
