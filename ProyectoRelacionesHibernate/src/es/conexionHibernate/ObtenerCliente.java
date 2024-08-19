package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Cliente.class)
													.addAnnotatedClass(DetallesCliente.class)
													.buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();

			//obtener DetallesCliente
			DetallesCliente detallesdeCliente = miSession.get(DetallesCliente.class, 4);
			
			System.out.println(detallesdeCliente);
			
			System.out.println(detallesdeCliente.getElCliente());
			
			//System.out.println("ahora vamos a eliminar en cascada");
			
			//miSession.delete(detallesdeCliente);


			miSession.getTransaction().commit();

			

		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {

			miSession.close();
			miFactory.close();
		}

	}
}
