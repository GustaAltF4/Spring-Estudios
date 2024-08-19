package es.practicas.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //esta anotacion indica q vamos a utiliazr programacion orientada a aspectos
@ComponentScan("es.practicas.aop") //y esta anotacion indica donde debe ir a buscar los aspectos
public class Configuracion {

}
