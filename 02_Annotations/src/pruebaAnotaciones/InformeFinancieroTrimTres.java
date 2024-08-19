package pruebaAnotaciones;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrimTres implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion Informe financiero favorable del trimetre 3";
	}

}
