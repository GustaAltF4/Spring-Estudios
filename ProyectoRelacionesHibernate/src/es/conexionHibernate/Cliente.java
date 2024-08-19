package es.conexionHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
	

	
	//construcctor por defecto
	
	public Cliente() {
	}
	
	//constructor con parametros
	public Cliente(String nombre, String apellido, String direccion) {//NO se indica el id porq es autoincremetal en sql
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public DetallesCliente getDetalles() {
		return detalles;
	}

	public void setDetalles(DetallesCliente detalles) {
		this.detalles = detalles;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}

	
	public void agregarPedidos(Pedido elPedido) {
		
		if(pedidos==null) pedidos= new ArrayList<>();
		
		//añade el pedido a la lista
		pedidos.add(elPedido);
		
		elPedido.setCliente(this);
		
	}



	//mapear la relacion 1:1
	@OneToOne(cascade=CascadeType.ALL)//esta anotacion hace q las qwerys se ejecuten en cascada osea q si elimino o creo algun cliente hace lo mismo en detallescliente 
	@JoinColumn(name="id") 
	private DetallesCliente detalles; //se crea un campo del tipo de la columna a relacionar en este caso DetallesCliente
		
	
	//mepear relacion 1:n usando List por q pueden ser muchos pedidos en un solo cliente
	@OneToMany(fetch=FetchType.LAZY,mappedBy="cliente",cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Pedido> pedidos;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//basicamente con esto va a reconocer la clase principal cuando se consulten los datos
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="direccion")
	private String direccion;

}
