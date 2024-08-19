package pruebaAnotaciones;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
 * Cuando aplicas la anotación @Component a una clase,
 * Spring la detecta automáticamente durante el escaneo de clases y la registra como un bean en el contenedor de Spring.
 * Esto significa que Spring se encargará de crear y gestionar la instancia de esta clase.
 * 
 * si no declaramos entre parentesis el id del bean ("ComercianteExperimentado") el nombre q toma es el mismo nombre de la clase
 * pero con la primera letra en minuscula
 */

@Component("ComercianteExperimentado")
//@Scope("prototype")
public class ComercianteExperimentado implements Empleados {
	
	//Ejecución de  codigo despues de creacion del bean
	//estos metodos @PostConstruct @PreDestroy NO DEBEN RECIBIR ARGUEMNTOS
	// y tampoco se puedne ejecutar si la clase esta en @Scope("prototype") porq solo funcionan con el ciclo de vida del bean en Singleton
	
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		
		System.out.println("ejecutado tras creacion de bean");
		//aca iria todo el codigo q se necesita antes de la creacion del bean
		
	}
	
	//Ejecución de  codigo despues de apagado contenedor Spring
	//posiblemente estos metodos en versiones de java mas adelantadas no se puedan importar estas anotaciones asi q se deberian importar desde los jarfiles
	
	@PreDestroy
	public void ejecutaAntesDestruccion() {
		
		System.out.println("ejecutado antes de la destruccion de bean");
		//aca iria todo el codigo q se necesita antes de q el bean se destruya
		
	}
	

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender, vender, y vender mas";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		//return "Esto es un informe generado por el comerciante";
		return nuevoInforme.getInformeFinanciero();
	}
	@Autowired // tambien se puede usar sobre el mismo campo creado y se inyecta igual 
	@Qualifier("informeFinancieroTrimCuatro")
	//cuando hay mas de una clase q implementa la interfez el programa se rompe porq no sabe cual usar entonces con el @qualifier aclaramos el id del bean a utilizar
	private CreacionInformeFinanciero nuevoInforme;
	//(se puede usar sobre setter,constructor, un metodo cualquiera,o campos de clase como este caso)
	
	
	//Autowired sobre constructor
	//en este caso @Autowired hace q spring scannee por medio del constructor y se fije q clase (InformeFinancieroTrimUno ya marcada como un @Component)
	// implementa la interfaz CreacionInformeFinanciero y lo guarda en nuevoInforme 
//	@Autowired
//	public ComercianteExperimentado(CreacionInformeFinanciero nuevoInforme) {
//		this.nuevoInforme = nuevoInforme;
//	}
//	
	//Autowired sobre un setter
//	@Autowired
//	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
//		this.nuevoInforme = nuevoInforme;
//	}
	
	
	
	

}
