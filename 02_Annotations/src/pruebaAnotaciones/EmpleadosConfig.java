package pruebaAnotaciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration con esta anotacion usamos esta clase como el archivo de confuuracion
//del prpyecto lo q permitiria prescindir del archivo xml 
//y tampoco haria falta cargar o instaciar el achivo xml de configuracion en el main


// @ComponentScan("pruebaAnotaciones") y con esta anotacion le decimos basicamente los mismo q en el xml
//<context:component-scan base-package="pruebaAnotaciones"></context:component-scan>
//basicamente le decimos a spring q escanee el paquete "pruebaAnotaciones"

@Configuration
@ComponentScan("pruebaAnotaciones")
@PropertySource("classpath:datosEmpresas.propiedades")//anotacion para leer datos o propiedades de un archivo externo
public class EmpleadosConfig {
	
	//definir el bean para informe finaciero para departamento compras
	
	@Bean
	public CreacionInformeFinanciero iformeFinancieroDptoComprasBean() {//el id del bean va a ser el mismo nombre del metodo
		
		return new InformeFinancieroDptoCompras();
	}
	
	//definir el bean para director financiero e inyectar dependencias
	
	@Bean
	public Empleados directorFinancieroBean() {
		return new DirectorFinanciero(iformeFinancieroDptoComprasBean());
	}

}
