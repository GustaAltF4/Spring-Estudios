package es.pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;


public class PruebasJDBC {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//todo lo q sea conectar con base de datos tiene q estar dentro de try-catch
		
		//especificar la direccion del servidor donde se encuentra la base de datos
		String jdbcURL="jdbc:mysql://localhost:3306/relacioneshibernate?useSSL=false";
		
		//especificar usuario y contraseña
		String usuario= "root";
		String contra= "2015guscho12345";
		
		try {
			
			System.out.println("Intentando conectar con la BBDD"+ jdbcURL);
			//coneccion propiamente dicha
			Connection miConexion = DriverManager.getConnection(jdbcURL, usuario, contra);
			
			System.out.println("Conexion Existosa!!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		

      
          
		
	}

}
