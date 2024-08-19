package pruebaAnotaciones;

import org.springframework.beans.factory.annotation.Value;

public class DirectorFinanciero implements Empleados {
	
	private CreacionInformeFinanciero informeFinanciero;
	@Value("${email}")//anotacion para leer el dato de un archivo externo previamente aclarado la clase de configuracion con @PropertySource
	private String email;
	@Value("${nombreEmpresa}")//el campo a inyectar del archivo externo debe estar aclarado entre ("${}")
	private String nombreEmpre;
	

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestion y direccion de operaciones financieras de la empresa";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return informeFinanciero.getInformeFinanciero();
	}

	//constructor de campo informeFinanciero
	public DirectorFinanciero(CreacionInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}

	//getter email y nombre empresa
	public String getEmail() {
		return email;
	}

	public String getNombreEmpre() {
		return nombreEmpre;
	}
	
	
	
	
	
	
}
