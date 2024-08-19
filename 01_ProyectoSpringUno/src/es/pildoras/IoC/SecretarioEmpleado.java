package es.pildoras.IoC;

public class SecretarioEmpleado implements Empleados {
	
	private CreacionInformes InformeNuevo;
	
	// en vez de un constructor usamos un setter
	public void setInformeNuevo(CreacionInformes informeNuevo) {
		InformeNuevo = informeNuevo;
	}
	
	private String email;
	private String nombreEmpresa;
	
	//getters y setters de esos campos (email,nombreEmpresa)
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
		
		return "Gestionar la agenda de los jefes";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe generado por el secretario: "+ InformeNuevo.getInformes();
	}

}
