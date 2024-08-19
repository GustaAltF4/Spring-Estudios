package es.ejercicios.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Secundaria")
public class TirarControlador {
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() { //proporciona el formulario
		return "FormularioSaludo1";//en el return se aclara el nombre del archivo .jsp o html al q accede el metodo  
	}
	
	//ejecutarlo asi daria error al haber 2 rutas con el mismo nombre
	//para solucionarlo se puede obviamente cambiar la ruta o si es obligatorio poner ese nombre
	//tambien se podria agregar un @RequestMapping("/rutadeDesvio") a la clase en si para cambiar las rutas entras las 
	//2 clases q tienen rutas con el mismo nombre esto emplica q habria q cambiar 
	// el jsp que llama a las rutas en cuestion
	@RequestMapping("/procesarFormulario3")
	public String otroProcesoFormulario(@RequestParam("nombreAlumno")String nombre, Model modelo) {
		nombre+= "es el peor alumno"; 
		String mensajeFinal= "¿Quien es el peor alumno? "+ nombre;
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		return"RespuestaFormularioSaludo1";
	}
}
