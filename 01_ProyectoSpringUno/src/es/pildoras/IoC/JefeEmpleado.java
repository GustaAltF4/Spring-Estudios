package es.pildoras.IoC;

public class JefeEmpleado implements Empleados{
	
	private CreacionInformes InformeNuevo;
	
	
	public JefeEmpleado(CreacionInformes informeNuevo) {
		InformeNuevo = informeNuevo;
	}

	public String getTareas() {
		return "Gestiono las tareas relativas a los empleados a mi cargo";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe presentado por el Jefe con rectificaciones: "+ InformeNuevo.getInformes();
	}

}
