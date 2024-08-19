package controlador.es.DAO;

import java.util.List;

import controlador.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getClientes();

	public void isertarCliente(Cliente elCliente);

	public Cliente getClienteUnico(int id);

	public void eliminarCliente(int id);
	
	
}
