package es.conexionHibernate;

import javax.persistence.*;
/*
 * @Entity:

-Esta anotación indica que la clase es una entidad JPA (Java Persistence API) que se mapea a una tabla en una base de datos.
-JPA es una especificación de Java que simplifica el manejo de datos relacionales en aplicaciones Java.

@Table(name = "clientes"):

-Esta anotación se usa para especificar el nombre de la tabla en la base de datos a la que se mapeará esta entidad.
-En este caso, la tabla en la base de datos se llamará "clientes".
-Si no se especifica el nombre de la tabla, JPA usará el nombre de la clase como nombre de la tabla por defecto.
 */



@Entity
@Table(name="clientes")
public class Clientes {
	

	
	//construcctor por defecto
	
	public Clientes() {
	}
	
	//constructor con parametros
	public Clientes(String nombre, String apellidos, String direccion) {//NO se indica el id porq es autoincremetal en sql
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	
	//get y set
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	//toString
	
	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//basicamente con esto va a reconocer la clase principal cuando se consulten los datos
	@Column(name="id")
	private int id;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellidos")
	private String apellidos;
	@Column(name="Direccion")
	private String direccion;
	
	/*
	 * @Id: Marca el campo que actúa como clave primaria en la entidad.
	 * 
	 * @GeneratedValue(strategy=GenerationType.IDENTITY) le dice a Hibernate que use una estrategia de generación de valores auto-incrementales para el campo id.
	 * 
	 * @Column(name="..."): Mapea el campo de la entidad a una columna específica en la base de datos.
	 */

}
