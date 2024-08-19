package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml")
							  .addAnnotatedClass(Cliente.class)
							  .addAnnotatedClass(DetallesCliente.class)
							  .buildSessionFactory();
		
		Session miSession= miFactory.openSession();
		

		try {

			miSession.beginTransaction();
			
			//obtener el cliente a eliminiar
			DetallesCliente detallesDelCliente= miSession.get(DetallesCliente.class, 3);
			
			detallesDelCliente.getElCliente().setDetalles(null);//esto intentaria establecer como nulos los detalles de el cliente pero como la BBDD esta relacionada no funciona porq quedaria una clave foranea libre
			
			//eliminar el cliente si no es null
			if (detallesDelCliente!=null) {
				
				miSession.delete(detallesDelCliente);
			}
		
			miSession.getTransaction().commit();
			
			if (detallesDelCliente!=null) System.out.println("Registro eliminado correctamente en BBDD");
			else System.out.println("No se encontro el cliente");
				 
			miSession.close();
			
		}finally {
			
			miFactory.close();
		}
		

	}

}
