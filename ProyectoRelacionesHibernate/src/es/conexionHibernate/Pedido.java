package es.conexionHibernate;

import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido {
	
	
	
	
	public Pedido() {
	}



	//constructor
	public Pedido(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
	

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	



	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", formapago=" + formapago + "]";
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="fecha")
	private GregorianCalendar fecha;
	@Column(name="forma_pago")
	private String formapago;
	
	//relacion de varios a uno
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})//todos menos remove porq no se quiere eliminar en casada
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

}
