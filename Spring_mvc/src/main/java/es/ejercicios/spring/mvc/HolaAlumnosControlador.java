package es.ejercicios.spring.mvc;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/Principal")
public class HolaAlumnosControlador {
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() { //proporciona el formulario
		return "FormularioSaludo1";//en el return se aclara el nombre del archivo .jsp o html al q accede el metodo  
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario() { //proporciana la respuesta al formulario
		return"RespuestaFormularioSaludo1";
	}
	
	//metodo q procesa la informacion q queremos agregasr al modelo y despues agrega la vista
	@RequestMapping("/procesarFormulario2")
	public String otroProcesoFormulario(HttpServletRequest request, Model modelo) {//recibe 2 parametros el request y el modelo
		
		//LEER LA INFO QUE VIENE DEL CUADRO DE TEXTO Y AGREGAR MAS INFORMACION
		String nombre= request.getParameter("nombreAlumno");// request.getParameter("valor del atributo 'name' en el html")
		//request.getParameter() es un método de la clase HttpServletRequest en la API de Servlets de Java,
		//utilizado para obtener los valores de los parámetros enviados en una solicitud HTTP.
		//Este método es especialmente útil para manejar datos enviados desde formularios HTML mediante métodos GET o POST.
		
		nombre+= "es el mejor alumno";
		
		String mensajeFinal= "¿Quien es el mejor alumno? "+ nombre; 
		//agregamos texto en este caso adelante y atras de lo obtenido
		
		//AGREGANDO INFO AL MODELO
		
		//model.addAttribute("nombre", valor)
		modelo.addAttribute("mensajeClaro", mensajeFinal);//modelo.addAttribute(String identificativo, objeto valor)
		
		// "mensajeClaro" es el id q identifica el modelo del atributo q se agrega al modelo
		// se puede acceder a ese valor usando en este caso ${mensajeClaro}
		
		//El método model.addAttribute() en Spring MVC se utiliza para agregar atributos al modelo,
		//que luego serán accesibles en la vista (generalmente un archivo JSP).
		//Este método se usa comúnmente en controladores para pasar datos desde el backend a la vista.
		
		//FINALMENTE DEVUELVE LA VISTA OSEA EL HTML O JSP 
		return"RespuestaFormularioSaludo1";
	}
	
	@RequestMapping("/procesarFormulario3")
	public String otroProcesoFormulario(@RequestParam("nombreAlumno")String nombre, Model modelo) {
		nombre+= "es el mejor alumno";
		String mensajeFinal= "¿Quien es el mejor alumno? "+ nombre;
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		return"RespuestaFormularioSaludo1";
	}
	
	//Ambos enfoques son válidos y puedes usar el que mejor se adapte a tus necesidades.
	//Si solo necesitas leer uno o algunos parámetros de la solicitud, @RequestParam es más simple y claro.
	//Sin embargo, si necesitas acceder a múltiples parámetros, cabeceras o atributos de sesión, HttpServletRequest puede ser más flexible.

}
