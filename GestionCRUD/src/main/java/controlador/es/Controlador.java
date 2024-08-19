package controlador.es;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import controlador.entity.Cliente;
import controlador.es.DAO.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired
	private ClienteDAO clienteDAO; //todos los metodos de clienteDAO estan programados en la interfaz y clase 
	
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		
		//obtener los clientes desde el DAO
		
		List <Cliente> losClientes= clienteDAO.getClientes();
		
		//agregarlos al modelo
		
		elModelo.addAttribute("clientes",losClientes);//con ese id se agregan a la vista
		
		
		return "lista-clientes";
	}
	
	//2 mapeo de la url a la q redirigia el boton
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model elModelo) {
		
		//bind datos clientes
		Cliente elCliente= new Cliente();
		
		elModelo.addAttribute("cliente",elCliente); //al modelo le agregamos como atributo el ciente contruido
		
		return "formularioCliente"; //y devuelve la vista formularioCliente
	}
	
	//4 mapeo de la url insertarCliente que va a redirigir a la ruta donde se muestran los clentes
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		
		//insertar cliente en BBDD
		clienteDAO.isertarCliente(elCliente);//pasando por parametro el cliente q viene del formulario
		
		return"redirect:/cliente/lista";//redireccionar
	}
	
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int Id, Model elModelo) {
		
		//Obtener el cleinte con el id q le pasamos por parametro
		
		Cliente elCliente = clienteDAO.getClienteUnico(Id);
		
		//Establecer el cleinte como atributo del modelo
		
		elModelo.addAttribute("cliente",elCliente);
		
		//Enviar al Formulario
		
		return "formularioCliente";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int Id) {
		
		//eliminar el cliente
		
		clienteDAO.eliminarCliente(Id);

		
		//Redireccionar a la lista de clientes asi se actualiza
		
		return "redirect:/cliente/lista";
	}
	
	
	
	

}
