package controlador.es.DAO;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controlador.entity.Cliente;

@Repository
public class ClienteDAOclase implements ClienteDAO {

	@Override
	@Transactional//esta anotacion en Spring ayuda a manejar la gestión de transacciones de manera automática, eliminando la necesidad de realizar operaciones manuales como commit, save, rollback, etc.
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		//obtener la session
		
		Session miSession= sessionFactory.getCurrentSession();//guardamos la sesion en miSession
		
		//crear la query (consulta)
		
		Query<Cliente> miQuery=miSession.createQuery("from Cliente",Cliente.class);
		
		//ejecutar la query y devolver restultados
		
		List<Cliente> clientes=miQuery.getResultList();
		
		return clientes;
	}
	
	@Autowired   //@Autowired está indicando a Spring que debe inyectar automáticamente una instancia de SessionFactory en el campo sessionFactory de la clase ClienteDAOclase
	private SessionFactory sessionFactory;//igual al archivo de config

	@Override
	@Transactional
	public void isertarCliente(Cliente elCliente) {
		
		//obtener la session
		
		Session miSession= sessionFactory.getCurrentSession();//guardamos la sesion en miSession
				
		//insertar el cliente
		
		//miSession.save(elCliente);// .save hace un ...insert into... en la BBDD 
		miSession.saveOrUpdate(elCliente);//con .saveOrUpdate podemos guardar o actualizar
	}

	@Override
	@Transactional
	public Cliente getClienteUnico(int id) {
		//obtener la sesion
		
		Session miSession= sessionFactory.getCurrentSession();
		
		//obtener la informacion del cliente seleccionado
		
		Cliente elCliente= miSession.get(Cliente.class, id);
		
		
		return elCliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		
		//obtener la sesion
		
		Session miSession= sessionFactory.getCurrentSession();
		
		//borrar el cliente de la BBDD utilizando como criterio su id correspondiente
		
		Query<?> consulta= miSession.createQuery("delete from Cliente where id=:IdDelCliente");
		
		consulta.setParameter("IdDelCliente", id);
		
		consulta.executeUpdate();
		
		
	}

}
