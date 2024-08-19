package es.conexionHibernate;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidosCliente {

	
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
			Cliente elcliente= miSession.get(Cliente.class, 1);
			
			//crear el pedido
			Pedido pedido1=new Pedido(new GregorianCalendar (2024,6,14));
			Pedido pedido2=new Pedido(new GregorianCalendar (2024,5,23));
			Pedido pedido3=new Pedido(new GregorianCalendar (2024,7,2));
			
			//agregar pedidos al ciente
			elcliente.agregarPedidos(pedido1);
			elcliente.agregarPedidos(pedido2);
			elcliente.agregarPedidos(pedido3);
			
			//guardar los pedidos en la base de datos en la tabla pedido
			
			miSession.save(pedido1);
			miSession.save(pedido2);
			miSession.save(pedido3);
			
		
			miSession.getTransaction().commit();
			
			System.out.println("Registros insertados correctamente en BBDD");
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			miSession.close();
			miFactory.close();
		}
		

	}

}
