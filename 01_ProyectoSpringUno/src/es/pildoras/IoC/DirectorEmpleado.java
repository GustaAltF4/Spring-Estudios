package es.pildoras.IoC;

public class DirectorEmpleado implements Empleados {

	//creacion de campo tipo CreacionInformes (interfaz)
	
	private CreacionInformes InformeNuevo;
	
	// creacion del constructor q inyecta la dependecia
	public DirectorEmpleado(CreacionInformes informenuevo) {
		
		this.InformeNuevo= informenuevo;
	}
	
	private String email;
	private String nombreEmpresa;
	
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@Override
	public String getTareas() {

		return "Gestionar la plantilla de la empresa";
	}

	@Override
	public String getInforme() {
		
		return "informe creado por el director: "+ InformeNuevo.getInformes();
	}
	
	//metodo init. Ejecutar tareas antes de que el bean este disponible
	
	public void metodoInicial() {
		
		System.out.println("Dentro del metodo init. Aqui irian las tareas a ejecutar antes de que el bean este listo");
		
	}
	
	//metodo destroy. Ejecutar tareas despues de que el bean haya sido utilizado
	
	public void metodoFinal() {
		
		System.out.println("Dentro del metodo destroy. Aqui irian las tareas a ejecutar despues de utilizar el bean");
		
	}
	
	
	

}
