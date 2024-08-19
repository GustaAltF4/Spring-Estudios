package es.ejercicios.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@RequestMapping("/muestraFormulario")

	// el modelo es el objeto q sirve de puente de datos entre el controlador y las
	// vistas
	// metodo q devuelve la vista del formulario para registrar alumnos
	public String muestraFormulario(Model modelo) {

		// creamos objeto Alumno
		Alumno elAlumno = new Alumno();

		// Guardamos en el modelo el objeto q queremos q viaje a la vista
		modelo.addAttribute("elAlumno", elAlumno);

		// devolvemos la vista
		return "alumnoRegistroFormulario";

	}

	/*
	 * ---USOS DE @ModelAttribute--- 
	 * Para Vincular Datos del Modelo: 
	 * -Se usa para vincular datos de un formulario HTML a un objeto de modelo. 
	 * -Automáticamente llena el objeto de modelo con los datos de los parámetros de solicitud HTTP.
	 * 
	 * Para Preparar Datos para Vistas: 
	 * -Se usa para preparar datos que deben estar disponibles en todas las vistas que maneja un controlador.
	 */
	@InitBinder
	public void miBinder(WebDataBinder binder) {
		StringTrimmerEditor recortaEspaciosBlanco = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, recortaEspaciosBlanco);
	
	}

	@RequestMapping("/procesarFormulario")
	// metodo q devuelve la vista del registro cargado
	public String procesarFormulario(@Valid @ModelAttribute("elAlumno") Alumno elAlumno, BindingResult resultadoValidacion) {
		//cuando se utiliza una validacion tanto si son correctos o erroneos 
		//se almacenan en un objeto tipo BindingResult entonces habria q pasarlo como parametro
		//ademas hay q indicar al metodo q se estan usando validaciones agregando @Valid 
		
		// @ModelAttribute("nombre-identificativo-del-model")Obejto nombreDelObjeto
		// los datos se rescatan por medio de jsp tags en la vista
		
		if (resultadoValidacion.hasErrors()) {
			return "alumnoRegistroFormulario";//si hay errores en la validacion nos devuelve la vista del formulario
		}else {
			return "confirmacionRegistroAlumno";//si no hay errores devuelve la vista del registro cargado
		}
		//solo quedaria agregar el mensaje de error en el formulario .jsp

	}

}
