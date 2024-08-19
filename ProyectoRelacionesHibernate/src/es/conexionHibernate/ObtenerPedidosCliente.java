package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ObtenerPedidosCliente {

	
	public static void main(String[] args) {
		
SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml")
							  .addAnnotatedClass(Cliente.class)
							  .addAnnotatedClass(DetallesCliente.class)
							  .addAnnotatedClass(Pedido.class)
							  .buildSessionFactory();
		
		Session miSession= miFactory.openSession();
		

		try {

			miSession.beginTransaction();
			//obtener cliente de la tabla de la base de datos
			//Cliente elcliente= miSession.get(Cliente.class, 1);
			
			//(EN CASO DE Q SE HALLA CERRADO LA SESION)
			Query<Cliente> consulta= miSession.createQuery("SELECT CL FROM Cliente CL JOIN FETCH CL.pedidos WHERE CL.id=:elClienteId",Cliente.class);
			
			consulta.setParameter("elClienteId", 1);
			
			Cliente elcliente= consulta.getSingleResult();
			
			System.out.println("Cliente: "+ elcliente);//forma de resulver si el fetch es LAZY y la sesion fue cerrada antes de pedir algo 
			//lo q hace es cargar los archivos en memoria 
			
			//System.out.println("Pedidos:"+ elcliente.getPedidos());
			

		
			
			miSession.getTransaction().commit();
			miSession.close();
			System.out.println("Pedidos:"+ elcliente.getPedidos());
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			miSession.close();
			miFactory.close();
		}
		

	}

}
