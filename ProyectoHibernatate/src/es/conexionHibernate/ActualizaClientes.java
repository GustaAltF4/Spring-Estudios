package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//todos import de hibernate

public class ActualizaClientes {

	public static void main(String[] args) {
		
		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		Session miSession= miFactory.openSession();
		
		try {
//			int clienteID=2;
//		
//			miSession.beginTransaction();
//	
//			Clientes miCliente= miSession.get(Clientes.class, clienteID);//se selecciona el cliente con el id=2 
//			
//			miCliente.setNombre("Nicolas"); //le cambia el nombre a nicolas
			
// 			OTRA FORMA
			
			miSession.beginTransaction();
			
			miSession.createQuery("update Clientes set apellidos= 'Rodriguez' where apellidos like 'D%'").executeUpdate();
			//cambia todos los apellidos q empicen con D a Rodriguez
			miSession.createQuery("delete Clientes where direccion = 'Coya'").executeUpdate();
			//elimina el cliente cuya direccion es igual a Coya
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro actualizado correctamente en BBDD");
			
			miSession.close();
			
		}finally {
			
			miFactory.close();
		}
		
	}

}
