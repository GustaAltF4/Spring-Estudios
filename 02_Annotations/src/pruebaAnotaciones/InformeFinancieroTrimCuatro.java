package pruebaAnotaciones;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrimCuatro implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion de informe de cierre de año";
	}

}
