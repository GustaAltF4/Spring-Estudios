package es.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {
	
	public static void main(String[] args) {
		
		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		Session miSession= miFactory.openSession();
		
		try {
			
			//Comenzar sesion
			miSession.beginTransaction();
			
			//Consulta de clientes
			 List<Clientes> losClientes = miSession.createQuery("FROM Clientes", Clientes.class).getResultList();//si no se incluye , Clientes.class funciona igual
			//almacena en la lista losClientes los resultado de la instruccion "from clientes" .getResultList(); los obtiene y guarda
			
			//mostrar los clientes
			leerLista(losClientes);
			
			// las consultas se basan en las clases de entidad de Java y sus propiedades, no directamente en las tablas
			//osea q aunque mi tabla se llame clientes yo tengo q hacer la consulta en base a la clase de java llamada Clientes
			//e igual con el campo aunque la columna de la tabla sea Apellidos yo tengo q hacer la consulta en base al campo de mi clase q se llama apellidos
			
			//Consulta: devuelve los Gomez
			losClientes = miSession.createQuery("FROM Clientes cl WHERE cl.apellidos='Gomez'", Clientes.class).getResultList();

			leerLista(losClientes);
				
			//Consulta: devuelve los q viven en Las Heras o se apellidan delgado
			losClientes = miSession.createQuery("FROM Clientes cl WHERE cl.apellidos='Delgado' or cl.direccion='Las Heras'", Clientes.class).getResultList();
				
			leerLista(losClientes);
				
			//commit
			miSession.getTransaction().commit();
			
			//cerrar la sesion
			miSession.close();
				
			
			
		}finally {
			miFactory.close();
		}
		
	}

	private static void leerLista(List<Clientes> losClientes) {
		for (Clientes unClientes : losClientes) {
			System.out.println(unClientes);
			
		}
	}
}

