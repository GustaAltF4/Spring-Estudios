package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {
		
SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml")
							  .addAnnotatedClass(Cliente.class)
							  .addAnnotatedClass(DetallesCliente.class)
							  .addAnnotatedClass(Pedido.class)
							  .buildSessionFactory();
		
		Session miSession= miFactory.openSession();
		

		try {
			
			
			Cliente cliente1= new Cliente("Gustavo","Acosta","Lavalle");
			DetallesCliente detallesCliente1= new DetallesCliente("www.eljompi2.com","2614672333","OTRO cliente");
            
			//asociar los objetos usando el setter de la clase relacionada 
			cliente1.setDetalles(detallesCliente1);
			
			miSession.beginTransaction();
			
			miSession.save(cliente1);
			//guardando solamente cliente 1 tambien se guarda automaticamente la informacion relacionada osea los datos de detallesCliente
		
			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en BBDD");
			
			miSession.close();
			
		}finally {
			
			miFactory.close();
		}
		

	}

}
