package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

	public static void main(String[] args) {
		
SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml")
							  .addAnnotatedClass(Cliente.class)
							  .addAnnotatedClass(DetallesCliente.class)
							  .buildSessionFactory();
		
		Session miSession= miFactory.openSession();
		

		try {

			miSession.beginTransaction();
			
			//obtener el cliente a eliminiar
			Cliente elCliente= miSession.get(Cliente.class, 3);
			
			//eliminar el cliente si no es null
			if (elCliente!=null) {
				System.out.println("Cliente a eliminar encontrado: "+elCliente.getNombre());
				miSession.delete(elCliente);
			}
		
			miSession.getTransaction().commit();
			
			if (elCliente!=null) System.out.println("Registro eliminado correctamente en BBDD");
			else System.out.println("No se encontro el cliente");
				 
			miSession.close();
			
		}finally {
			
			miFactory.close();
		}
		

	}

}
