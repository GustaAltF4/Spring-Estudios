package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//todos import de hibernate

public class GuardaClientesPrueba {

	public static void main(String[] args) {
		// new Configuration().configure("hibernate.cfg.xml"): Crea una nueva configuración de Hibernate utilizando el archivo hibernate.cfg.xml
		// addAnnotatedClass(Clientes.class): Añade la clase Clientes como una clase anotada que Hibernate gestionará.
		// buildSessionFactory(): Construye una SessionFactory a partir de la configuración especificada.
		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		//Session miSession = miFactory.openSession();: Abre una nueva sesión (Session) desde la SessionFactory
		Session miSession= miFactory.openSession();
		
		try {//siempre dentro de bloques try
			
			//nuevo objeto de clase cliente (clase la cual tiene todas las annotations para q sea cargado correctamente a la BBDD)
			Clientes cliente1= new Clientes("Sandra","Delgado","Goya");
			
            //Inicia una transacción. En Hibernate, las operaciones de escritura (como insertar, actualizar y eliminar)
			//deben realizarse dentro de una transacción.
			miSession.beginTransaction();
			
			miSession.save(cliente1);//Guarda el objeto cliente1 en la base de datos.
			
			//miSession.getTransaction().rollback();
			miSession.getTransaction().commit();//Confirma la transacción, aplicando todos los cambios realizados durante la transacción a la base de datos.
			
			System.out.println("Registro insertado correctamente en BBDD");
			
			//LEER REGISTROS
			
			miSession.beginTransaction();//comenzar una nueva transaccion
			
			System.out.println("Lectura del registro con id:"+ cliente1.getId());
			
			Clientes clienteInsertado= miSession.get(Clientes.class, cliente1.getId());//este objeto almacena los datos del cliente q este en la base de datos
			
			System.out.println("Registro: "+ clienteInsertado);//muetra los datos
			
			miSession.getTransaction().commit();
			
			System.out.println("Terminado!.");
			
			miSession.close();
			
		}finally {
			
			miFactory.close();
		}
		
	}

}
