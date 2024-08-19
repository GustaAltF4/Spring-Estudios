package es.pildoras.IoC;

public class Informe implements CreacionInformes{

	@Override
	public String getInformes() {
		// caracteristica en comun q van a tener todos nuestros objetos (jefe,secretario,director)
		return "Esta es la presentacion del informe";
	}

}
